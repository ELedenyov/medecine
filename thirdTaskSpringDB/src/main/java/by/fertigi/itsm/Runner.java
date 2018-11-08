package by.fertigi.itsm;

import by.fertigi.itsm.service.IAuthorizationService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfigMain.class);
        context.registerShutdownHook();

        if(context.getBean(IAuthorizationService.class).authorization()){
            Runnable mainMenu = (Runnable) context.getBean("mainMenu");
            mainMenu.run();
        } else {
            System.out.println("you entered your username or password incorrectly");
        }
    }
}