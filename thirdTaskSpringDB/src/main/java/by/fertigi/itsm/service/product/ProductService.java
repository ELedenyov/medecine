package by.fertigi.itsm.service.product;

import by.fertigi.itsm.entity.Product;

public interface ProductService {
    void create(Product product) throws Exception;
    Product read(int id) throws Exception;
    void update(Product product) throws Exception;
    void deleteById(int id) throws Exception;
}
