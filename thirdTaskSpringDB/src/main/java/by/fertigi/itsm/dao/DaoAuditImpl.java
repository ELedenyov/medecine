package by.fertigi.itsm.dao;

import by.fertigi.itsm.entity.AuditOperation;
import by.fertigi.itsm.exception.BusinessException;
import by.fertigi.itsm.exception.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class DaoAuditImpl implements DaoAudit {
    private JdbcTemplate template;

    @Autowired
    public DaoAuditImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Transactional
    public void auditCreate(AuditOperation auditOperation) throws Exception {
        try {
            String sql = "INSERT INTO auditoperations ( date, status, action) VALUES (?, ?, ?)";
            GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
            int updateRow = template.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setDate(1, auditOperation.getDate());
                ps.setString(2, auditOperation.getStatus());
                ps.setString(3, auditOperation.getAction());
                return ps;
            }, generatedKeyHolder);
            if (updateRow == 0) {
                throw new BusinessException("the audit was not completed, 0 rows were changed");
            }
            auditOperation.setId(generatedKeyHolder.getKey().intValue());
        } catch (DataAccessException e){
            throw new DatabaseException(e.getMessage());
        }
    }
}
