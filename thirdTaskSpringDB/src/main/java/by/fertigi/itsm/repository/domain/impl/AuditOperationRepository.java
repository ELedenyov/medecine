package by.fertigi.itsm.repository.domain.impl;

import by.fertigi.itsm.entity.AuditOperation;
import by.fertigi.itsm.entity.User;
import by.fertigi.itsm.repository.AbstractListRepository;
import by.fertigi.itsm.repository.domain.IAuditRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

@Repository
public class AuditOperationRepository extends AbstractListRepository<AuditOperation> implements IAuditRepository{
    @Override
    public void create(boolean success, User user, Object... params) {
        String data = Arrays.stream(params)
                .map(Object::toString)
                .collect(Collectors.joining(";"));

        data = user.getLogin() + " : " + data;

        String status = success + "";

        AuditOperation auditOperation = new AuditOperation(new Date(), status, data, user);
        em.persist(auditOperation);
    }

    @Override
    protected Class<AuditOperation> getEntityClass() {
        return AuditOperation.class;
    }
}
