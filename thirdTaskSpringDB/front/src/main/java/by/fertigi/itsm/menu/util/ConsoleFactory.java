package by.fertigi.itsm.menu.util;

import by.fertigi.itsm.entity.IEntity;

public interface ConsoleFactory<E extends IEntity> {
    E create();
    void update(E entity);
}
