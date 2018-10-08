package by.fertigi.itsm.console;

import java.util.Scanner;

public abstract class BaseConsoleLogic {
    protected Scanner scanner = new Scanner(System.in);

    public void mainMenu() throws Exception {
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
                    System.out.println("create");
                    create();
                    break;
                case 2:
                    System.out.println("read");
                    read();
                    break;
                case 3:
                    System.out.println("update");
                    update();
                    break;
                case 4:
                    System.out.println("delete");
                    delete();
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
         System.out.println("1.Create");
         System.out.println("2.Read");
         System.out.println("3.Update");
         System.out.println("4.Delete");
         System.out.println();
         System.out.println("0.exit");
         System.out.println();
         System.out.println();
         System.out.println();
     }

    abstract void create() throws Exception;

    abstract void read() throws Exception;

    abstract void update() throws Exception;

    abstract void delete() throws Exception;

}
