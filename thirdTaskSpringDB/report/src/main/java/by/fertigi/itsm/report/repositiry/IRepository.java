package by.fertigi.itsm.report.repositiry;

import by.fertigi.itsm.entity.Entity;

import java.util.List;

public interface IRepository<T extends Entity> {
    T getEntity(int i);
    List<T> getAll();
}
