package com.MITM142.data;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderView {
    private Integer id;
    private Integer serviceId;
    private String shortDescription;
    private String longDescription;
    private String type;
    private Integer ownerId;
    private BigDecimal price;
    private String timeInHours;
    private Integer buyerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;

}
