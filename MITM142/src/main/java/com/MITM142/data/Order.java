package com.MITM142.data;

import lombok.Data;

@Data
public class Order {
    private Integer id;
    private Integer serviceId;
    private Integer buyerId;
    private String address;

}
