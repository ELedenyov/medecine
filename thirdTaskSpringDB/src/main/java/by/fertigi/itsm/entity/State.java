package by.fertigi.itsm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class State implements Entity{
    private int id;
    private String code;
    private String name;
}
