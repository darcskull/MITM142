package com.MITM142.data;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phoneNumber;

}
