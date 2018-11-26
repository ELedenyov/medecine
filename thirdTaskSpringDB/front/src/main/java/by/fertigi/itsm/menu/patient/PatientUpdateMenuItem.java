package by.fertigi.itsm.menu.patient;

import by.fertigi.itsm.entity.Patient;
import by.fertigi.itsm.menu.IMenuItem;
import by.fertigi.itsm.menu.util.ConsoleFactory;
import by.fertigi.itsm.menu.util.MenuHelper;
import by.fertigi.itsm.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@PatientMenuItem
public class PatientUpdateMenuItem implements IMenuItem {

    private final ConsoleFactory<Patient> patientConsoleFactory;
    private final PatientRepository patientRepository;
    private final MenuHelper menuHelper;

    @Autowired
    public PatientUpdateMenuItem(
            ConsoleFactory<Patient> patientConsoleFactory,
            PatientRepository patientRepository,
            MenuHelper helper
    ) {
        this.patientConsoleFactory = patientConsoleFactory;
        this.patientRepository = patientRepository;
        this.menuHelper = helper;
    }

    @Override
    public String getTitle() {
        return "Update patient";
    }

    @Override
    @Transactional
    public int doAction() {
        System.out.println("Enter patient id:");
        int id = menuHelper.readInt();
        Patient patient = patientRepository.findById(id).get();
        if (patient == null) {
            System.out.println("patient not found");
            return 0;
        } else {
            System.out.println(patient);
        }
        patientConsoleFactory.update(patient);
        patientRepository.save(patient);
        return 0;
    }
}
