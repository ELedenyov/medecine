package by.fertigi.itsm.mappers;

import by.fertigi.itsm.entity.Transaction;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TransactionRowMapper implements IEntityRowMapper<Transaction>{
    private final String TABLE_NAME = "transactions";

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Nullable
    @Override
    public Transaction mapRow(ResultSet resultSet, int i) throws SQLException {
        Transaction transaction = new Transaction();
        transaction.setId(resultSet.getInt("id"));
        transaction.setIdPatient(resultSet.getInt("patient_id"));
        transaction.setIdProduct(resultSet.getInt("product_id"));
        transaction.setDate(resultSet.getDate("date"));
        return transaction;
    }
}
