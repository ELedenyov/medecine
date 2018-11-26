package by.fertigi.itsm.web.model;

import lombok.Data;

import java.util.Date;

@Data
public class ProductSaleDto implements IDto {
    private Integer id;
    private Integer patientId;
    private Integer productId;
    private Date date;
}
