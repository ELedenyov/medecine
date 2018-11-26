package by.fertigi.itsm.repository;

import by.fertigi.itsm.entity.AuditOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditOperationRepository extends JpaRepository<AuditOperation, Integer> {
}
