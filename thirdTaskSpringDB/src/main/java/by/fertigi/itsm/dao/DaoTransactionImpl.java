package by.fertigi.itsm.dao;

import by.fertigi.itsm.annotations.AuditOperationAnnotation;
import by.fertigi.itsm.entity.Transaction;
import by.fertigi.itsm.exception.BusinessException;
import by.fertigi.itsm.exception.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
@Qualifier(value = "daoTransaction")
public class DaoTransactionImpl implements DaoTransaction {
    private final JdbcTemplate template;

    @Autowired
    public DaoTransactionImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    @AuditOperationAnnotation(operation = "sale")
    public void createTransaction(Transaction transaction) throws Exception {
        try {
            String sql = "INSERT INTO transactions (patient_id, product_id, date) VALUES (?, ?, ?)";
            GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
            int updateRow = template.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, transaction.getIdPatient());
                ps.setInt(2, transaction.getIdProduct());
                ps.setDate(3, transaction.getDate());
                return ps;
            }, generatedKeyHolder);
            if (updateRow == 0) {
                throw new BusinessException("the transaction was not carried out, 0 rows were changed");
            }
            transaction.setId(generatedKeyHolder.getKey().intValue());
        } catch (DataAccessException e){
            throw new DatabaseException(e.getMessage());
        }
    }
}
