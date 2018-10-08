package by.fertigi.itsm.report.mapper;

import by.fertigi.itsm.entity.Patient;
import by.fertigi.itsm.entity.Product;
import by.fertigi.itsm.entity.Transaction;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public interface TransactionMapper extends ProductMapper, PatientMapper, StateMapper{
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
