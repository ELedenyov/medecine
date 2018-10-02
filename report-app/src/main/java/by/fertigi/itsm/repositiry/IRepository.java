package by.fertigi.itsm.repositiry;

import by.fertigi.itsm.model.Entity;

import java.util.List;

public interface IRepository<T extends Entity> {
    T getEntity(int i);
    List<T> getAll();
}
