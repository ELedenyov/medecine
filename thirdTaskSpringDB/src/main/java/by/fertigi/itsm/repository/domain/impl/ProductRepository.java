package by.fertigi.itsm.repository.domain.impl;

import by.fertigi.itsm.entity.Product;
import by.fertigi.itsm.processors.UserHolder;
import by.fertigi.itsm.repository.AbstractCrudRepository;
import by.fertigi.itsm.repository.domain.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public class ProductRepository extends AbstractCrudRepository<Product> implements IProductRepository {
    @Override
    public Product findByName(String name) {
        TypedQuery<Product> query = em.createQuery("select p from products p join fetch p.state s where p.name = :name", Product.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    protected Class<Product> getEntityClass() {
        return Product.class;
    }

    @Override
    protected void addCreatedBy(Product product) {
        product.setCreatedBy(UserHolder.getCurrentUser());
    }

    @Override
    protected void addUpdateBy(Product product) {
        product.setUpdatedBy(UserHolder.getCurrentUser());
    }
}
