package by.fertigi.itsm.mappers;

import by.fertigi.itsm.entity.State;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class StateRowMapper implements IEntityRowMapper<State>{
    private final String TABLE_NAME = "states";

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Nullable
    @Override
    public State mapRow(ResultSet resultSet, int i) throws SQLException {
        State state = new State();
        state.setId(resultSet.getInt("id"));
        state.setName(resultSet.getString("name"));
        state.setCode(resultSet.getString("code"));
        return state;
    }
}
