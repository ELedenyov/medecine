package by.fertigi.itsm.dao;

import by.fertigi.itsm.annotations.AuditOperationAnnotation;
import by.fertigi.itsm.entity.Patient;
import by.fertigi.itsm.mappers.IEntityRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class DaoCrudPatient extends AbstractDaoCrudRepository<Patient> implements CrudOperation<Patient>{

    @Autowired
    public DaoCrudPatient(JdbcTemplate template, IEntityRowMapper<Patient> mapper) {
        super(template, mapper);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    @AuditOperationAnnotation(operation = "create patient")
    public void create(Patient patient) {
        String sql = "INSERT INTO patients (phone, state_id) VALUES (?,?)";
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        int updateRow = template.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, patient.getPhone());
            ps.setInt(2, patient.getState().getId());
            return ps;
        }, generatedKeyHolder);
        patient.setId(generatedKeyHolder.getKey().intValue());
    }

    @Override
    @Transactional
    @AuditOperationAnnotation(operation = "update patient")
    public void update(Patient patient) {
        String sql = "UPDATE patients SET phone = ?, state_id = ? WHERE id = ?";
        int updateRow = template.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, patient.getPhone());
            ps.setInt(2, patient.getState().getId());
            ps.setInt(3, patient.getId());
            return ps;
        });
    }

    @Override
    @Transactional
    @AuditOperationAnnotation(operation = "read patient")
    public Patient read(int id) {
        return super.read(id);
    }

    @Override
    @Transactional
    @AuditOperationAnnotation(operation = "delete patient")
    public void deleteById(int id) {
        super.deleteById(id);
    }
}
