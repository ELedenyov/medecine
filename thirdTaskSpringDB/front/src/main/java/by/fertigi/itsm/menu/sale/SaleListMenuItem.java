package by.fertigi.itsm.menu.sale;

import by.fertigi.itsm.menu.IMenuItem;
import by.fertigi.itsm.repository.ProductSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@SaleMenuItem
public class SaleListMenuItem implements IMenuItem {

    private final ProductSaleRepository saleRepository;

    @Autowired
    public SaleListMenuItem(ProductSaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public String getTitle() {
        return "Print all sales";
    }

    @Override
    @Transactional
    public int doAction() {
        saleRepository.findAll().forEach(System.out::println);
        return 0;
    }
}
