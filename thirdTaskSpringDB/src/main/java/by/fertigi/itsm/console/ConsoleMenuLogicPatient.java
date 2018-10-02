package by.fertigi.itsm.console;

import by.fertigi.itsm.entity.Patient;
import by.fertigi.itsm.service.patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ConsoleMenuLogicPatient extends BaseConsoleLogic{
    private final PatientService service;

    @Autowired
    public ConsoleMenuLogicPatient(PatientService service) {
        this.service = service;
    }

    @Override
    protected void create() throws Exception {
        System.out.println("This menu is for creating a patient");
        printEnterPhone();
        String phone = scanner.nextLine();
        //штат вводить имя, номер выбрать из списока штатов или что.
        printEnterState();
        int state = Integer.parseInt(scanner.nextLine());
        service.create(new Patient(phone, state));
        System.out.println("patient create!");
        System.out.println();
        System.out.println();
        System.out.println();
    }

    @Override
    protected void read() throws Exception {
        System.out.println("This menu is for reading a patient");
        System.out.println("Enter id patient:");
        String line = scanner.nextLine();
        Patient read = (Patient)service.read(Integer.parseInt(line));
        System.out.println(read);
        System.out.println();
        System.out.println();
        System.out.println();
    }

    @Override
    public void update() throws Exception {
        System.out.println("This menu is for updating a patient");
        System.out.println("Enter your id:");
        int id = Integer.parseInt(scanner.nextLine());
        printEnterPhone();
        String phone = scanner.nextLine();
        printEnterState();
        int state = Integer.parseInt(scanner.nextLine());
        service.update(new Patient(id, phone, state));
        System.out.println("patient updating!");
        System.out.println();
        System.out.println();
        System.out.println();
    }

    @Override
    public void delete() throws Exception {
        System.out.println("This menu is for deleting a patient");
        System.out.println("Enter patient id:");
        int id = Integer.parseInt(scanner.nextLine());
        service.deleteById(id);
        System.out.println("patient delete!");
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public void printEnterState(){
        System.out.println("Enter your state:");
    }

    public void printEnterPhone(){
        System.out.println("Enter your phone:");
    }
}
