package com.springleaf.mapper;

import com.springleaf.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Select("select o.orderId,o.orderTime,o.total,state,u.username from t_order o,t_user u where o.userId=u.userId")
    List<Order> showOrder();
}
