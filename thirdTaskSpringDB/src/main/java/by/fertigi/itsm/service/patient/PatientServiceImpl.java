package by.fertigi.itsm.service.patient;

import by.fertigi.itsm.dao.CrudOperation;
import by.fertigi.itsm.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("patientServiceImpl")
public class PatientServiceImpl implements PatientService{
    private CrudOperation<Patient> dao;

    @Autowired
    public PatientServiceImpl(@Qualifier(value = "daoCrudPatient") CrudOperation<Patient> dao) {
        this.dao = dao;
    }

    @Override
    public void create(Patient patient) throws Exception {
        System.out.println("create");
        dao.create(patient);
    }

    @Override
    public Patient read(int id) throws Exception {
        return dao.read(id);
    }

    @Override
    public void update(Patient patient) throws Exception {
        dao.update(patient);
    }

    @Override
    public void deleteById(int id) throws Exception {
        dao.deleteById(id);
    }
}
