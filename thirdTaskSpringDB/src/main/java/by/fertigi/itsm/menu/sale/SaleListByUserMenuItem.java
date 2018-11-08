package by.fertigi.itsm.menu.sale;

import by.fertigi.itsm.menu.IMenuItem;
import by.fertigi.itsm.repository.domain.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@SaleMenuItem
public class SaleListByUserMenuItem implements IMenuItem{
    private final ITransactionRepository saleRepository;

    @Autowired
    public SaleListByUserMenuItem(ITransactionRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public String getTitle() {
        return "Sale list by user";
    }

    @Override
    @Transactional
    public int doAction() {
        saleRepository.findByUser().forEach(System.out::println);
        return 0;
    }
}
