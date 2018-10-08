package by.fertigi.itsm.report;

import by.fertigi.itsm.report.menu.MainMenu;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;

public class RunnerReport {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfigReport.class);
        try {
            context.getBean(MainMenu.class).mainMenu();
        } catch (ParseException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }
}
