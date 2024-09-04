package com.springleaf.service.impl;

import com.springleaf.mapper.UserOrderMapper;
import com.springleaf.pojo.UserOrderDTO;
import com.springleaf.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderServiceImpl implements UserOrderService {
    @Autowired
    UserOrderMapper userOrderMapper;
    @Override
    public List<UserOrderDTO> getUserOrders() {
        return userOrderMapper.getUserOrders();
    }
}
