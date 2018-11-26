package by.fertigi.itsm.menu.product;

import by.fertigi.itsm.entity.Product;
import by.fertigi.itsm.menu.IMenuItem;
import by.fertigi.itsm.repository.ProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@ProductMenuItem
public class ProductListMenuItem implements IMenuItem {

    private final ProductRepository productRepository;

    public ProductListMenuItem(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public String getTitle() {
        return "Print product list";
    }

    @Override
    @Transactional
    public int doAction() {
        productRepository.findAll().forEach(System.out::println);
        return 0;
    }
}
