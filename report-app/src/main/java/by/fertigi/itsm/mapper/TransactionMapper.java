package by.fertigi.itsm.mapper;

import by.fertigi.itsm.model.Patient;
import by.fertigi.itsm.model.Product;
import by.fertigi.itsm.model.State;
import by.fertigi.itsm.model.Transaction;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public interface TransactionMapper {
    @Select("select * from transactions " +
            "INNER JOIN patients ON transactions.patient_id = patients.id " +
            "INNER JOIN products ON transactions.product_id = products.id " +
            "where transactions.id = #{transactionId}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "date", column = "date"),
            @Result(property = "patient", column="patient_id", javaType = Patient.class, one=@One(select="selectPatient")),
            @Result(property = "product", column="product_id", javaType = Product.class, one=@One(select="selectProduct"))
    })
    Transaction getTransaction(@Param("transactionId") int transactionId);

    @Select("SELECT * FROM patients INNER JOIN states ON patients.state_id = states.id WHERE patients.id = #{patient_id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "state", column = "state_id", javaType = State.class, one = @One(select = "selectState"))
    })
    Patient selectPatient(int patient_id);

    @Select("SELECT * FROM products INNER JOIN states ON products.state_id = states.id WHERE products.id = #{product_id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "state", column = "state_id", javaType = State.class, one = @One(select = "selectState"))
    })
    Product selectProduct(int product_id);

    @Select("SELECT * FROM states WHERE states.id = #{state_id}")
    State selectState(int state_id);

    @Select("select * from transactions " +
            "INNER JOIN patients ON transactions.patient_id = patients.id " +
            "INNER JOIN products ON transactions.product_id = products.id " +
            "where date between #{dateFrom} and #{dateTo}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "date", column = "date"),
            @Result(property = "patient", column="patient_id", javaType = Patient.class, one=@One(select="selectPatient")),
            @Result(property = "product", column="product_id", javaType = Product.class, one=@One(select="selectProduct"))
    })
    List<Transaction> getTransactions(@Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo);

}
