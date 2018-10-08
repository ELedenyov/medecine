package by.fertigi.itsm.report.menu;

import by.fertigi.itsm.entity.Transaction;
import by.fertigi.itsm.report.repositiry.TransactionRepository;
import by.fertigi.itsm.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@Component
public class MainMenu {
    private final TransactionRepository repository;
    private final ReportService reportService;
    private final String dateFormat = "dd/MM/yyyy";
    private final SimpleDateFormat simpleDateFormat;
    private final Scanner scanner;

    @Autowired
    public MainMenu(TransactionRepository repository, ReportService reportService) {
        this.repository = repository;
        this.reportService = reportService;
        this.simpleDateFormat  = new SimpleDateFormat(dateFormat);
        this.scanner = new Scanner(System.in);
    }

    private void printMainMenu(){
        System.out.println("1.Create report");
        System.out.println();
        System.out.println("0.Exit");
    }

    public void mainMenu() throws ParseException {
        int operation = -1;
        while (operation != 0) {
            printMainMenu();
            operation = Integer.parseInt(scanner.nextLine());
            switch (operation) {
                case 1:
                    createReport();
                    System.out.println("report create!");
                    break;
                case 0:
                    System.out.println("bye!");
                    break;
                default:
                    System.out.println("not support operation");
                    break;
            }
        }
    }

    private void createReport() throws ParseException {
        System.out.println("Enter date start period: ");
        Date dateStart = simpleDateFormat.parse(scanner.nextLine());
        System.out.println("Enter date finish period: ");
        Date dateFinish = simpleDateFormat.parse(scanner.nextLine());
        List<Transaction> allTransaction = repository.getAllTransaction(dateStart, dateFinish);
        reportService.createReport(allTransaction);
    }
}
