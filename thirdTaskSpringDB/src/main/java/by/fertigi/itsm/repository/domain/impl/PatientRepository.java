package by.fertigi.itsm.repository.domain.impl;

import by.fertigi.itsm.entity.Patient;
import by.fertigi.itsm.processors.UserHolder;
import by.fertigi.itsm.repository.AbstractCrudRepository;
import by.fertigi.itsm.repository.domain.IPatientRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public class PatientRepository extends AbstractCrudRepository<Patient> implements IPatientRepository {
    @Override
    public Patient findByPhone(String phone) {
        TypedQuery<Patient> query = em.createQuery("select p from patients p join fetch p.state s where p.phone = :phone", Patient.class);
        query.setParameter("phone", phone);
        return query.getSingleResult();
    }

    @Override
    protected Class<Patient> getEntityClass() {
        return Patient.class;
    }

    @Override
    protected void addCreatedBy(Patient patient) {
        patient.setCreatedBy(UserHolder.getCurrentUser());
    }

    @Override
    protected void addUpdateBy(Patient patient) {
        patient.setUpdatedBy(UserHolder.getCurrentUser());
    }
}
