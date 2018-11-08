package by.fertigi.itsm.repository.domain;

import by.fertigi.itsm.entity.Product;
import by.fertigi.itsm.repository.ICrudRepository;

public interface IProductRepository extends ICrudRepository<Product> {
    Product findByName(String name);
}
