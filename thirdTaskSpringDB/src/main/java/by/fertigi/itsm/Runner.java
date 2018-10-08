package by.fertigi.itsm;

import by.fertigi.itsm.console.ConsoleMenuLogicMain;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfigMain.class);
        ConsoleMenuLogicMain console = context.getBean(ConsoleMenuLogicMain.class);
        console.logicMainMenu();
    }
}