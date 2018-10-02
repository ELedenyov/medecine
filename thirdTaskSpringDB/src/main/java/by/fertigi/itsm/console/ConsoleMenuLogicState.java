package by.fertigi.itsm.console;

import by.fertigi.itsm.entity.State;
import by.fertigi.itsm.service.state.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleMenuLogicState {
    private final StateService stateService;
    private final Scanner scanner;

    @Autowired
    public ConsoleMenuLogicState(@Qualifier("stateServiceImpl") StateService stateService) {
        this.stateService = stateService;
        this.scanner = new Scanner(System.in);
    }

    public void mainMenu(){
        int operation = -1;
        while (operation != 0) {
            printMainMenu();
            String line = scanner.nextLine();
            try {
                operation = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("You entered an incorrect operation! Try again!");
                continue;
            }
            switch (operation) {
                case 1:
                    getById();
                    break;
                case 2:
                    getByName();
                    break;
                case 3:
                    getByCode();
                    break;
                case 4:
                    getAll();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Enter the correct operation number!");
                    operation = -1;
                    break;
            }
        }
    }

    void printMainMenu(){
        System.out.println();
        System.out.println("Select operation:");
        System.out.println("1.Get by id");
        System.out.println("2.Get by name");
        System.out.println("3.Get by code");
        System.out.println("4.Get all");
        System.out.println();
        System.out.println("0.exit");
        System.out.println();
        System.out.println();
        System.out.println();
    }

    private void getById() {
        System.out.println("Enter state id:");
        int id = Integer.parseInt(scanner.nextLine());
        State state = stateService.getById(id);
        System.out.println(state);
    }

    private void getByName() {
        System.out.println("Enter state name:");
        String name = scanner.nextLine();
        State state = stateService.getByName(name);
        System.out.println(state);
    }

    private void getByCode() {
        System.out.println("Enter state code:");
        String code = scanner.nextLine();
        State state = stateService.getByCode(code);
        System.out.println(state);
    }

    private void getAll(){
        List<State> allStates = stateService.getAll();
        System.out.println(allStates);
    }
}
