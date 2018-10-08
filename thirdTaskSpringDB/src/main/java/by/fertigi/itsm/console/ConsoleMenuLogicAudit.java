package by.fertigi.itsm.console;

import by.fertigi.itsm.processors.EnableAuditOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleMenuLogicAudit{
    private final EnableAuditOperation enableAuditOperation;
    private final Scanner scanner;

    @Autowired
    public ConsoleMenuLogicAudit(EnableAuditOperation enableAuditOperation) {
        this.enableAuditOperation = enableAuditOperation;
        scanner = new Scanner(System.in);
    }

    public void mainMenu(){
        int operation = -1;
        while (operation != 0) {
            printMainMenu();
            System.out.println("Current state of the Audit Operation: " + enableAuditOperation.isEnable());
            try {
                operation = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("You entered an incorrect operation! Try again!");
                continue;
            }
            switch (operation) {
                case 1:
                    auditOperationON();
                    break;
                case 2:
                    auditOperationOFF();
                    break;
                case 0:
                    break;
            }

        }
    }

    private void printMainMenu(){
        System.out.println();
        System.out.println("1.Audit Operation ON");
        System.out.println("2.Audit Operation OFF");
        System.out.println();
        System.out.println("0.Exit");
    }

    public void auditOperationON(){
        enableAuditOperation.setEnable(true);
        System.out.println("You have enabled audit operation");
    }

    public void auditOperationOFF(){
        enableAuditOperation.setEnable(false);
        System.out.println("You turned off audit operation");
    }
}
