package by.fertigi.itsm.repository;

import by.fertigi.itsm.entity.IEntity;

public interface ICrudRepository<T extends IEntity> extends IListRepository<T> {
    void create(T t);
    void update(T t);
    void delete(T t);
}
