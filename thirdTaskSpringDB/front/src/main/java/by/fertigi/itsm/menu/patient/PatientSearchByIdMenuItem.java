package by.fertigi.itsm.menu.patient;

import by.fertigi.itsm.entity.Patient;
import by.fertigi.itsm.menu.IMenuItem;
import by.fertigi.itsm.menu.util.MenuHelper;
import by.fertigi.itsm.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@PatientMenuItem
public class PatientSearchByIdMenuItem implements IMenuItem {

    private final PatientRepository patientRepository;
    private final MenuHelper menuHelper;

    @Autowired
    public PatientSearchByIdMenuItem(PatientRepository patientRepository, MenuHelper menuHelper) {
        this.patientRepository = patientRepository;
        this.menuHelper = menuHelper;
    }

    @Override
    public String getTitle() {
        return "Search by id";
    }

    @Override
    @Transactional
    public int doAction() {
        System.out.println("Enter patient id:");
        Integer id = menuHelper.readInt();
        Patient patient = patientRepository.findById(id).get();
        if (patient == null) {
            System.out.println("patient not found");
        } else {
            System.out.println(patient);
        }
        return 0;
    }

    @Override
    public int priority() {
        return 3;
    }
}
