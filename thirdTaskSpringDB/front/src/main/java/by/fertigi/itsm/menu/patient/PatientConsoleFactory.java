package by.fertigi.itsm.menu.patient;

import by.fertigi.itsm.entity.Patient;
import by.fertigi.itsm.entity.State;
import by.fertigi.itsm.menu.util.ConsoleFactory;
import by.fertigi.itsm.menu.util.MenuHelper;
import by.fertigi.itsm.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientConsoleFactory implements ConsoleFactory<Patient> {

    private final MenuHelper helper;
    private final StateRepository stateRepository;



    @Autowired
    public PatientConsoleFactory(
            MenuHelper helper,
            StateRepository stateRepository) {
        this.helper = helper;
        this.stateRepository = stateRepository;
    }

    @Override
    public Patient create() {
        Patient patient = new Patient();
        update(patient);
        return patient;
    }

    @Override
    public void update(Patient patient) {
        System.out.println("Input phone:");
        String phone = helper.read();


        System.out.println("Input state code");
        String stateCode = helper.read();

        State state = stateRepository.findByCode(stateCode);

        patient.setPhone(phone);
        patient.setState(state);
    }
}
