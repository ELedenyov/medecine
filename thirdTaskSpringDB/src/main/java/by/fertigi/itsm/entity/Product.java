package by.fertigi.itsm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Entity{
    private int id;
    private String name;
    private int idState;

    public Product(String name, int idState) {
        this.name = name;
        this.idState = idState;
    }
}
