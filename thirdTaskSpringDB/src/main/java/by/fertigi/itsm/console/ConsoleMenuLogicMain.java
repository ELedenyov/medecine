package by.fertigi.itsm.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleMenuLogicMain {
    private final Scanner scanner;
    private final ConsoleMenuLogicPatient consoleMenuLogicPatient;
    private final ConsoleMenuLogicAudit consoleMenuLogicAudit;
    private final ConsoleMenuLogicProduct consoleMenuLogicProduct;
    private final ConsoleMenuLogicState consoleMenuLogicState;
    private final ConsoleMenuLogicTransaction consoleMenuLogicTransaction;

    @Autowired
    public ConsoleMenuLogicMain(ConsoleMenuLogicPatient consoleMenuLogicPatient,
                                ConsoleMenuLogicAudit consoleMenuLogicAudit,
                                ConsoleMenuLogicProduct consoleMenuLogicProduct,
                                ConsoleMenuLogicState consoleMenuLogicState,
                                ConsoleMenuLogicTransaction consoleMenuLogicTransaction) {
        this.consoleMenuLogicAudit = consoleMenuLogicAudit;
        this.consoleMenuLogicProduct = consoleMenuLogicProduct;
        this.consoleMenuLogicState = consoleMenuLogicState;
        this.consoleMenuLogicTransaction = consoleMenuLogicTransaction;
        this.consoleMenuLogicPatient = consoleMenuLogicPatient;
        this.scanner = new Scanner(System.in);
    }

    private void printMainMenu() {
        System.out.println();
        System.out.println("Select operation:");
        System.out.println("1.Crud operation with Patient");
        System.out.println("2.Crud operation with Product");
        System.out.println("3.Crud operation with State");
        System.out.println("4.Audit operations");
        System.out.println("5.Transaction menu");
        System.out.println();
        System.out.println("0.exit");
    }

    public void logicMainMenu() throws Exception {
        int operation = -1;
        while (operation != 0) {
            printMainMenu();
            try {
                operation = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("You entered an incorrect operation! Try again!");
                continue;
            }
            switch (operation) {
                case 1:
                    consoleMenuLogicPatient.mainMenu();
                    break;
                case 2:
                    consoleMenuLogicProduct.mainMenu();
                    break;
                case 3:
                    consoleMenuLogicState.mainMenu();
                    break;
                case 4:
                    consoleMenuLogicAudit.mainMenu();
                    break;
                case 5:
                    consoleMenuLogicTransaction.mainMenu();
                    break;
            }

        }

    }
}
