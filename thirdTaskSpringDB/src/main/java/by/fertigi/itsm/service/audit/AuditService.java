package by.fertigi.itsm.service.audit;


import by.fertigi.itsm.entity.AuditOperation;

public interface AuditService {
    void auditCreate(AuditOperation auditOperation) throws Exception;
}
