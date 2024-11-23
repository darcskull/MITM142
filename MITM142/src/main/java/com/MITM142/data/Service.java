package com.MITM142.data;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class Service {
    private Integer id;
    private String shortDescription;
    private String longDescription;
    private String type;
    private Integer userId;
    private BigDecimal price;
    private String timeInHours;
}