package by.fertigi.itsm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction implements Entity{
    private int id;
    private int idPatient;
    private int idProduct;
    private Date date;

    public Transaction(int idPatient, int idProduct, Date date) {
        this.idPatient = idPatient;
        this.idProduct = idProduct;
        this.date = date;
    }
}
