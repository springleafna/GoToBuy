package com.springleaf.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class UserOrderDTO {
    private Integer orderId;
    private Integer userId;
    private BigDecimal total;
    private String consignee;
    private String address;
    private String phone;
    private Timestamp orderTime;
    private String state;
    private String username;
}
