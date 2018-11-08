package by.fertigi.itsm.report.repositiry;

import by.fertigi.itsm.entity.IEntity;

import java.util.List;

public interface IRepository<T extends IEntity> {
    T getEntity(int i);
    List<T> getAll();
}
