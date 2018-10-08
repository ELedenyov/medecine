package by.fertigi.itsm.console;

import by.fertigi.itsm.entity.Patient;
import by.fertigi.itsm.entity.Product;
import by.fertigi.itsm.entity.Transaction;
import by.fertigi.itsm.service.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Scanner;

@Component
public class ConsoleMenuLogicTransaction {
    private final TransactionService service;
    private final Scanner scanner;

    @Autowired
    public ConsoleMenuLogicTransaction(@Qualifier("transactionServiceImpl") TransactionService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void mainMenu(){
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
                    createTransaction();
                    break;
            }

        }
    }

    private void printMainMenu(){
        System.out.println();
        System.out.println("Select operation:");
        System.out.println("1.Make a sale");
        System.out.println();
        System.out.println("0.exit");
    }

    private void createTransaction(){
        System.out.println("Enter id patient: ");
        int idPatient = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter id product: ");
        int idProduct = Integer.parseInt(scanner.nextLine());
        Date date = new Date(System.currentTimeMillis());
        Transaction transaction = new Transaction(new Patient(idPatient), new Product(idProduct), date);
        try {
            service.createTransaction(transaction);
        } catch (Exception e){
            System.out.println("operation failed, please try again");
        }

    }
}
