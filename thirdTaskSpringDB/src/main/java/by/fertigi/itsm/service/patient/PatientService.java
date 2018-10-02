package by.fertigi.itsm.service.patient;

import by.fertigi.itsm.entity.Patient;

public interface PatientService {
    void create(Patient patient) throws Exception;
    Patient read(int id) throws Exception;
    void update(Patient patient) throws Exception;
    void deleteById(int id) throws Exception;
}
