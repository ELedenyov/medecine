package by.fertigi.itsm.menu.product;

import by.fertigi.itsm.entity.Product;
import by.fertigi.itsm.menu.IMenuItem;
import by.fertigi.itsm.menu.util.ConsoleFactory;
import by.fertigi.itsm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ProductMenuItem
public class ProductCreateMenuItem implements IMenuItem {

    private final ConsoleFactory<Product> productConsoleFactory;
    private final ProductRepository productRepository;

    @Autowired
    public ProductCreateMenuItem(
            ConsoleFactory<Product> productConsoleFactory,
            ProductRepository productRepository) {
        this.productConsoleFactory = productConsoleFactory;
        this.productRepository = productRepository;
    }

    @Override
    public String getTitle() {
        return "Add product";
    }

    @Override
    public int doAction() {
        Product product = productConsoleFactory.create();
        productRepository.save(product);
        return 0;
    }
}
