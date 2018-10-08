package by.fertigi.itsm.mappers;

import by.fertigi.itsm.entity.Patient;
import by.fertigi.itsm.entity.State;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PatientRowMapper implements IEntityRowMapper<Patient>{
    private final String TABLE_NAME = "patients";

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Nullable
    @Override
    public Patient mapRow(ResultSet resultSet, int i) throws SQLException {
        Patient patient = new Patient();
        patient.setId(resultSet.getInt("id"));
        patient.setPhone(resultSet.getString("phone"));
        State state = new State();
        state.setId(resultSet.getInt("state_id"));
        state.setName(resultSet.getString("name"));
        state.setCode(resultSet.getString("code"));
        patient.setState(state);
        return patient;
    }
}
