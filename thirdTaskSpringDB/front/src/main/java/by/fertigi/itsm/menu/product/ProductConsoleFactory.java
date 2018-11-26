package by.fertigi.itsm.menu.product;

import by.fertigi.itsm.entity.Product;
import by.fertigi.itsm.entity.State;
import by.fertigi.itsm.menu.util.ConsoleFactory;
import by.fertigi.itsm.menu.util.MenuHelper;
import by.fertigi.itsm.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConsoleFactory implements ConsoleFactory<Product> {

    private final MenuHelper helper;
    private final StateRepository stateRepository;



    @Autowired
    public ProductConsoleFactory(
            MenuHelper helper,
            StateRepository stateRepository) {
        this.helper = helper;
        this.stateRepository = stateRepository;
    }

    @Override
    public Product create() {
        Product product = new Product();
        update(product);
        return product;
    }

    @Override
    public void update(Product product) {
        System.out.println("Input name:");
        String name = helper.read();


        System.out.println("Input state code");
        String stateCode = helper.read();

        State state = stateRepository.findByCode(stateCode);

        product.setName(name);
        product.setState(state);
    }
}
