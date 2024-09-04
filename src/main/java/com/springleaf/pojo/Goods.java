package com.springleaf.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Goods {
    private Integer goodsId;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private String type;
}
