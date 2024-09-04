package com.springleaf.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetail {
    private Integer orderDetailId;
    private Integer goodsId;
    private Integer goodsNum;
    private BigDecimal sumPrice;
    private Integer state;
    private Integer userid;
}
