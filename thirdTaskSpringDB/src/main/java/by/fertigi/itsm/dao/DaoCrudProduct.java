package by.fertigi.itsm.dao;

import by.fertigi.itsm.annotations.AuditOperationAnnotation;
import by.fertigi.itsm.entity.Product;
import by.fertigi.itsm.mappers.IEntityRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class DaoCrudProduct extends AbstractDaoCrudRepository<Product> implements CrudOperation<Product> {

    @Autowired
    public DaoCrudProduct(JdbcTemplate template, IEntityRowMapper<Product> mapper) {
        super(template, mapper);
    }


    @Override
    @Transactional
    @AuditOperationAnnotation(operation = "create product")
    public void create(Product product) {
        String sql = "INSERT INTO products (name, state_id) VALUES (?,?)";
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        int updateRow = template.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, product.getName());
            ps.setInt(2, product.getState().getId());
            return ps;
        }, generatedKeyHolder);
        product.setId(generatedKeyHolder.getKey().intValue());
    }

    @Override
    @Transactional
    @AuditOperationAnnotation(operation = "create product")
    public void update(Product product) {
        String sql = "UPDATE products SET name = ?, state_id = ? WHERE id = ?";
        int updateRow = template.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setInt(2, product.getState().getId());
            ps.setInt(3, product.getId());
            return ps;
        });
    }

    @Override
    @Transactional
    @AuditOperationAnnotation(operation = "read product")
    public Product read(int id) {
        return super.read(id);
    }

    @Override
    @Transactional
    @AuditOperationAnnotation(operation = "delete product")
    public void deleteById(int id) {
        super.deleteById(id);
    }
}
