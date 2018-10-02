package by.fertigi.itsm.dao;


import by.fertigi.itsm.entity.AuditOperation;

public interface DaoAudit {
    void auditCreate(AuditOperation auditOperation) throws Exception;
}
