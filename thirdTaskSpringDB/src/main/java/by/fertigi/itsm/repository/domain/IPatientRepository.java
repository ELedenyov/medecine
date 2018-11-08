package by.fertigi.itsm.repository.domain;

import by.fertigi.itsm.entity.Patient;
import by.fertigi.itsm.repository.ICrudRepository;

public interface IPatientRepository extends ICrudRepository<Patient> {
    Patient findByPhone(String phone);
}
