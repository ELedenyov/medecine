package by.fertigi.itsm.report.mapper;

import by.fertigi.itsm.entity.Product;
import by.fertigi.itsm.entity.State;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface ProductMapper {
    @Select("SELECT * FROM products INNER JOIN states ON products.state_id = states.id WHERE products.id = #{product_id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "state", column = "state_id", javaType = State.class, one = @One(select = "selectState"))
    })
    Product selectProduct(int product_id);
}
