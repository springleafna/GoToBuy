package com.springleaf.pojo;

import lombok.Data;

@Data
public class User {
    private Integer userId;
    private String username;
    private String password;
    private Integer type;
    private String token;
}
