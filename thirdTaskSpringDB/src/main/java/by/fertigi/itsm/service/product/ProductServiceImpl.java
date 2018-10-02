package by.fertigi.itsm.service.product;

import by.fertigi.itsm.dao.CrudOperation;
import by.fertigi.itsm.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {
    private CrudOperation<Product> dao;

    @Autowired
    public ProductServiceImpl(@Qualifier(value = "daoCrudProduct") CrudOperation<Product> dao) {
        this.dao = dao;
    }

    @Override
    public void create(Product product) throws Exception {
        dao.create(product);
    }

    @Override
    public Product read(int id) throws Exception {
        return dao.read(id);
    }

    @Override
    public void update(Product product) throws Exception {
        dao.update(product);
    }

    @Override
    public void deleteById(int id) throws Exception {
        dao.deleteById(id);
    }
}
