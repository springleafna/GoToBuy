package com.springleaf.service.impl;

import com.springleaf.mapper.OrderMapper;
import com.springleaf.pojo.Order;
import com.springleaf.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Override
    public List<Order> showOrder() {
        return orderMapper.showOrder();
    }
}
