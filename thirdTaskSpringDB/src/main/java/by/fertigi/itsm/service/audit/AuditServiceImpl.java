package by.fertigi.itsm.service.audit;

import by.fertigi.itsm.dao.DaoAudit;
import by.fertigi.itsm.entity.AuditOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("auditService")
public class AuditServiceImpl implements AuditService {
    private final DaoAudit daoAudit;


    @Autowired
    public AuditServiceImpl(DaoAudit daoAudit) {
        this.daoAudit = daoAudit;
    }

    @Override
    public void auditCreate(AuditOperation auditOperation) throws Exception {
        daoAudit.auditCreate(auditOperation);
    }

}
