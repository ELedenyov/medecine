package by.fertigi.itsm.repository;

import by.fertigi.itsm.entity.IEntity;

import javax.persistence.*;
import java.util.List;

public abstract class AbstractListRepository<T extends IEntity> implements IListRepository<T> {
    @PersistenceContext
    protected EntityManager em;

    @Override
    public List<T> findAll() {
        TypedQuery<T> query = em.createQuery("from " + getEntityClass().getAnnotation(Entity.class).name(), getEntityClass());
        return query.getResultList();
    }

    @Override
    public T find(Integer id) {
        return em.find(getEntityClass(), id);
    }

    protected abstract Class<T> getEntityClass();
}
