package by.fertigi.itsm.menu.product;

import by.fertigi.itsm.entity.Product;
import by.fertigi.itsm.menu.IMenuItem;
import by.fertigi.itsm.menu.util.ConsoleFactory;
import by.fertigi.itsm.repository.ICrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ProductMenuItem
public class ProductCreateMenuItem implements IMenuItem {

    private final ConsoleFactory<Product> productConsoleFactory;
    private final ICrudRepository<Product> patientRepository;

    @Autowired
    public ProductCreateMenuItem(
            ConsoleFactory<Product> productConsoleFactory,
            ICrudRepository<Product> patientRepository) {
        this.productConsoleFactory = productConsoleFactory;
        this.patientRepository = patientRepository;
    }

    @Override
    public String getTitle() {
        return "Add product";
    }

    @Override
    public int doAction() {
        Product product = productConsoleFactory.create();
        patientRepository.create(product);
        return 0;
    }
}
