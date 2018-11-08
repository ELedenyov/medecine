package by.fertigi.itsm.repository.domain;

import by.fertigi.itsm.entity.AuditOperation;
import by.fertigi.itsm.entity.User;
import by.fertigi.itsm.repository.IListRepository;

public interface IAuditRepository extends IListRepository<AuditOperation> {
    void create(boolean success, User user, Object... params);
}
