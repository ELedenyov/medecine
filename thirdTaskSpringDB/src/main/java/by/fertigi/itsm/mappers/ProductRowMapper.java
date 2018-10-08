package by.fertigi.itsm.mappers;

import by.fertigi.itsm.entity.Product;
import by.fertigi.itsm.entity.State;
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
        State state = new State();
        state.setId(resultSet.getInt("state_id"));
        state.setName(resultSet.getString("name"));
        state.setCode(resultSet.getString("code"));
        product.setState(state);
        product.setId(resultSet.getInt("id"));
        product.setName(resultSet.getString("name"));
        return product;
    }
}