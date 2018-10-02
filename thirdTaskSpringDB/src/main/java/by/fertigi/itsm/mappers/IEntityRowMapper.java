package by.fertigi.itsm.mappers;

import by.fertigi.itsm.entity.Entity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;


public interface IEntityRowMapper<T extends Entity> extends RowMapper<T> {
    String getTableName();
    T mapRow(ResultSet resultSet, int i) throws SQLException;
}
