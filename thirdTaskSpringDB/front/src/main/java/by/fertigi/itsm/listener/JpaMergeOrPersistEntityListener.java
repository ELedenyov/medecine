package by.fertigi.itsm.listener;

import by.fertigi.itsm.entity.ModifyMarker;
import by.fertigi.itsm.util.UserHolder;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import java.util.Map;

@Component
public class JpaMergeOrPersistEntityListener implements PersistEventListener, MergeEventListener, PreUpdateEventListener {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @PostConstruct
    private void init() {
        SessionFactoryImplementor sessionFactory = entityManagerFactory.unwrap(SessionFactoryImplementor.class);
        EventListenerRegistry eventListenerRegistry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
        JpaMergeOrPersistEntityListener listener = new JpaMergeOrPersistEntityListener();
        eventListenerRegistry.appendListeners(EventType.PERSIST, listener);
        eventListenerRegistry.appendListeners(EventType.MERGE, listener);
        eventListenerRegistry.appendListeners(EventType.PRE_UPDATE, listener);
    }

    @Override
    @Transactional
    public void onMerge(MergeEvent mergeEvent) throws HibernateException {
        if(mergeEvent.getResult() instanceof ModifyMarker){
            ModifyMarker result = (ModifyMarker) mergeEvent.getResult();
            result.setUpdatedBy(UserHolder.getCurrentUser());
        }
    }

    @Override
    public void onMerge(MergeEvent mergeEvent, Map map) throws HibernateException {

    }

    @Override
    @Transactional
    public void onPersist(PersistEvent persistEvent) throws HibernateException {
        if(persistEvent.getObject() instanceof ModifyMarker){
            ModifyMarker object = (ModifyMarker) persistEvent.getObject();
            if (object.getCreatedBy() == null) {
                object.setCreatedBy(UserHolder.getCurrentUser());
            }
            object.setUpdatedBy(UserHolder.getCurrentUser());
        }
    }

    @Override
    public void onPersist(PersistEvent persistEvent, Map map) throws HibernateException {

    }

    @Override
    public boolean onPreUpdate(PreUpdateEvent preUpdateEvent) {
        return false;
    }
}
