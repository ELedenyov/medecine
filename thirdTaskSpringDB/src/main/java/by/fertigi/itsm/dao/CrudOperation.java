package by.fertigi.itsm.dao;

import by.fertigi.itsm.entity.Entity;

import java.util.List;

public interface CrudOperation<T extends Entity> {
    void create(T t);
    T read(int id);
    void update(T t);
    void deleteById(int id);
    List<T> getAll();
}
