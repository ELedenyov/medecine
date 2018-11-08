package by.fertigi.itsm.repository;

import by.fertigi.itsm.entity.IEntity;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractCrudRepository<T extends IEntity> extends AbstractListRepository<T> implements ICrudRepository<T> {
    @Override
    @Transactional
    public void create(T t) {
        addCreatedBy(t);
        addUpdateBy(t);
        em.persist(t);
    }

    @Override
    @Transactional
    public void update(T t) {
        addUpdateBy(t);
        em.merge(t);
    }

    @Override
    @Transactional
    public void delete(T t) {
        em.remove(t);
    }

    protected abstract void addCreatedBy(T t);

    protected abstract void addUpdateBy(T t);
}
