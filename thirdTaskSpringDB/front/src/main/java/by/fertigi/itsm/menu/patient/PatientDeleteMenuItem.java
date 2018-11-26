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
public class PatientDeleteMenuItem implements IMenuItem {

    private final PatientRepository patientRepository;
    private final MenuHelper menuHelper;

    @Autowired
    public PatientDeleteMenuItem(PatientRepository patientRepository, MenuHelper menuHelper) {
        this.patientRepository = patientRepository;
        this.menuHelper = menuHelper;
    }


    @Override
    public String getTitle() {
        return "Delete patient";
    }

    @Override
    @Transactional
    public int doAction() {
        System.out.println("Input patient id:");
        Integer id = menuHelper.readInt();
        Patient patient = patientRepository.findById(id).get();
        if (patient == null) {
            System.out.println("patient not found");
        } else {
            patientRepository.delete(patient);
        }
        return 0;
    }

    @Override
    public int priority() {
        return 2;
    }
}
