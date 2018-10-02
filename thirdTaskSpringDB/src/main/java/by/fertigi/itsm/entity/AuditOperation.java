package by.fertigi.itsm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditOperation implements Entity{
    private int id;
    private Date date;
    private String status;
    private String action;
}
