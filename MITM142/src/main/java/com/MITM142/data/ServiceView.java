package com.MITM142.data;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ServiceView {
    private Integer serviceId;
    private String shortDescription;
    private String longDescription;
    private String type;
    private Integer userId;
    private BigDecimal price;
    private Integer timeInHours;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

}