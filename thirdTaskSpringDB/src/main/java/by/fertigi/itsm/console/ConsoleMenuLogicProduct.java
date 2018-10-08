package by.fertigi.itsm.console;

import by.fertigi.itsm.entity.Product;
import by.fertigi.itsm.entity.State;
import by.fertigi.itsm.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsoleMenuLogicProduct extends BaseConsoleLogic{
    private final ProductService service;

    @Autowired
    public ConsoleMenuLogicProduct(ProductService service){
        this.service = service;
    }

    @Override
    protected void create() throws Exception {
        try {
            System.out.println("This menu is for creating a product");
            printEnterName();
            String name = scanner.nextLine();
            printEnterState();
            int state = Integer.parseInt(scanner.nextLine());
            service.create(new Product(name, new State(state)));
            System.out.println("product create!");
            System.out.println();
            System.out.println();
            System.out.println();
        } catch (Exception e){
            System.out.println("operation failed, please try again");
        }
    }

    @Override
    protected void read() throws Exception {
        try {
            System.out.println("This menu is for reading a product");
            System.out.println("Enter id product:");
            String line = scanner.nextLine();
            Product product = (Product) service.read(Integer.parseInt(line));
            System.out.println(product);
            System.out.println();
            System.out.println();
            System.out.println();
        } catch (Exception e){
            System.out.println("operation failed, please try again");
        }
    }

    @Override
    public void update() {
        try {
            System.out.println("This menu is for updating a product");
            System.out.println("Enter product id:");
            int id = Integer.parseInt(scanner.nextLine());
            printEnterName();
            String name = scanner.nextLine();
            printEnterState();
            int state = Integer.parseInt(scanner.nextLine());
            service.update(new Product(id, name, new State(state)));
            System.out.println("Product updating!");
            System.out.println();
            System.out.println();
            System.out.println();
        } catch (Exception e){
            System.out.println("operation failed, please try again");
        }
    }

    @Override
    public void delete() throws Exception {
        try {
            System.out.println("This menu is for deleting a product");
            System.out.println("Enter product id:");
            int id = Integer.parseInt(scanner.nextLine());
            service.deleteById(id);
            System.out.println("product delete!");
            System.out.println();
            System.out.println();
            System.out.println();
        } catch (Exception e){
            System.out.println("operation failed, please try again");
        }
    }

    public void printEnterState(){
        System.out.println("Enter product state:");
    }

    public void printEnterName(){
        System.out.println("Enter name product:");
    }
}
