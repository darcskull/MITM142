package com.MITM142.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phoneNumber;

}
