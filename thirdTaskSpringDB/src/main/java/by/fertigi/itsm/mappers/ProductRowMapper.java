package by.fertigi.itsm.mappers;

import by.fertigi.itsm.entity.Product;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProductRowMapper implements IEntityRowMapper<Product>{
    private final String TABLE_NAME = "products";

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Nullable
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getInt("id"));
        product.setIdState(resultSet.getInt("state_id"));
        product.setName(resultSet.getString("name"));
        return product;
    }
}
