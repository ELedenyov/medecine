package by.fertigi.itsm;

import by.fertigi.itsm.menu.MainMenu;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        try {
            context.getBean(MainMenu.class).mainMenu();
        } catch (ParseException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }
}
