package by.fertigi.itsm.mappers;

import by.fertigi.itsm.entity.AuditOperation;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AuditOperationRowMapper implements IEntityRowMapper<AuditOperation> {
    private final String TABLE_NAME = "auditoperations";

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Nullable
    @Override
    public AuditOperation mapRow(ResultSet resultSet, int i) throws SQLException {
        AuditOperation auditOperation = new AuditOperation();
        auditOperation.setId(resultSet.getInt("id"));
        auditOperation.setDate(resultSet.getDate("date"));
        auditOperation.setStatus(resultSet.getString("status"));
        auditOperation.setAction(resultSet.getString("action"));
        return auditOperation;
    }
}
