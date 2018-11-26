package by.fertigi.itsm.web.controller.impl;

import by.fertigi.itsm.entity.Product;
import by.fertigi.itsm.web.controller.AbstractCrudController;
import by.fertigi.itsm.web.model.ProductDto;
import by.fertigi.itsm.web.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController extends AbstractCrudController<Product, ProductDto> {

    @Autowired
    public ProductController(ICrudService<Product, ProductDto> service) {
        super(service);
    }

}
