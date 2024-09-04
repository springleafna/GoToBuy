package com.springleaf.mapper;

import com.springleaf.pojo.UserOrderDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserOrderMapper {
    List<UserOrderDTO> getUserOrders();
}
