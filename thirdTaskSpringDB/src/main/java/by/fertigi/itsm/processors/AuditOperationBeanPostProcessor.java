package by.fertigi.itsm.processors;

import by.fertigi.itsm.annotations.AuditOperationAnnotation;
import by.fertigi.itsm.entity.AuditOperation;
import by.fertigi.itsm.service.audit.AuditService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Proxy;
import java.sql.Date;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class AuditOperationBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Object> beans = new HashMap<>();

    @Autowired
    @Lazy
    private AuditService auditService;

    @Autowired
    @Lazy
    private EnableAuditOperation enableAuditOperation;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (Arrays.stream(bean.getClass().getMethods()).anyMatch(method -> method.getAnnotation(AuditOperationAnnotation.class) != null)) {
            System.out.println(beanName);
            beans.put(beanName, bean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beans.containsKey(beanName)){
            Class originalBeanClass = beans.get(beanName).getClass();
            Object proxyBean = Proxy.newProxyInstance(originalBeanClass.getClassLoader(),
                    originalBeanClass.getInterfaces(),
                    (proxy, method, args) -> {
                        Annotation annotation = originalBeanClass.getMethod(
                                method.getName(),
                                method.getParameterTypes()).getAnnotation(AuditOperationAnnotation.class);
                        if (annotation != null && enableAuditOperation.isEnable()) {
                            final String action = ((AuditOperationAnnotation) annotation).operation();
                            AuditOperation auditOperation = new AuditOperation();
                            auditOperation.setAction(action);
                            auditOperation.setDate(new Date(System.currentTimeMillis()));
                            String allArgs = Arrays.stream(args)
                                    .map(Object::toString)
                                    .collect(Collectors.joining(";"));
                            try {
                                Object returnObject = method.invoke(bean, args);
                                auditOperation.setStatus("operation is done, args: " + allArgs);
                                return returnObject;
                            } catch (Exception e){
                                auditOperation.setStatus("operation not done, message: " + e.getMessage()
                                        + ", reason: "
                                        + e.getClass()
                                        + ", args: " + allArgs);
                                throw new Exception(e);
                            } finally {
                                auditService.auditCreate(auditOperation);
                            }
                        } else {
                            return method.invoke(bean, args);
                        }
                    });
            return proxyBean;
        } else {
            return bean;
        }
    }
}
