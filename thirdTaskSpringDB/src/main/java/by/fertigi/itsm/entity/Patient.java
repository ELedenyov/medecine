package by.fertigi.itsm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient implements Entity{
    private int id;
    private String phone;
    private int idState;

    public Patient(String phone, int idState) {
        this.phone = phone;
        this.idState = idState;
    }
}
