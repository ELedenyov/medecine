package by.fertigi.itsm.menu.patient;

import by.fertigi.itsm.entity.Patient;
import by.fertigi.itsm.menu.IMenuItem;
import by.fertigi.itsm.menu.util.ConsoleFactory;
import by.fertigi.itsm.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@PatientMenuItem
public class PatientCreateMenuItem implements IMenuItem {

    private final ConsoleFactory<Patient> patientConsoleFactory;
    private final PatientRepository patientRepository;

    @Autowired
    public PatientCreateMenuItem(
            ConsoleFactory<Patient> patientConsoleFactory,
            PatientRepository patientRepository) {
        this.patientConsoleFactory = patientConsoleFactory;
        this.patientRepository = patientRepository;
    }

    @Override
    public String getTitle() {
        return "Add patient";
    }

    @Override
    public int doAction() {
        Patient patient = patientConsoleFactory.create();
        patientRepository.save(patient);
        return 0;
    }
}
