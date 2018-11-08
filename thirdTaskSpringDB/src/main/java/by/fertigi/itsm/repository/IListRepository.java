package by.fertigi.itsm.repository;

import by.fertigi.itsm.entity.IEntity;

import java.util.List;

public interface IListRepository<T extends IEntity> {
    List<T> findAll();
    T find(Integer id);
}
