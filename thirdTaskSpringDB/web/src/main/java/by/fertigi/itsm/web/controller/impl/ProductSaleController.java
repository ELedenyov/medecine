package by.fertigi.itsm.web.controller.impl;

import by.fertigi.itsm.entity.Transaction;
import by.fertigi.itsm.web.controller.AbstractCrudController;
import by.fertigi.itsm.web.model.ProductSaleDto;
import by.fertigi.itsm.web.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/product_sale")
public class ProductSaleController extends AbstractCrudController<Transaction, ProductSaleDto> {

    @Autowired
    public ProductSaleController(ICrudService<Transaction, ProductSaleDto> service) {
        super(service);
    }
}
