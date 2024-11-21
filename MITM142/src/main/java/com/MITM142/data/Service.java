package com.MITM142.data;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class Service {
    private Integer id;
    private String shortDescription;
    private String longDescription;
    private String type;
    private Integer userId;
    private BigDecimal price;
    private Integer timeInHours;

}