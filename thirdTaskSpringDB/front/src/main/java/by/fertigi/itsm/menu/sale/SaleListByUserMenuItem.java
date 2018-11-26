package by.fertigi.itsm.menu.sale;

import by.fertigi.itsm.menu.IMenuItem;
import by.fertigi.itsm.util.UserHolder;
import by.fertigi.itsm.repository.ProductSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@SaleMenuItem
public class SaleListByUserMenuItem implements IMenuItem {
    private final ProductSaleRepository saleRepository;

    @Autowired
    public SaleListByUserMenuItem(ProductSaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public String getTitle() {
        return "Sale list by user";
    }

    @Override
    @Transactional
    public int doAction() {
        //ToDo inspect work
        saleRepository.findAllByCreatedBy(UserHolder.getCurrentUser()).forEach(System.out::println);
        return 0;
    }
}
