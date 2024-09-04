package com.springleaf.controller;

import com.springleaf.common.Result;
import com.springleaf.service.OrderService;
import com.springleaf.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    UserOrderService userOrderService;

    @GetMapping
    Result showOrder(){
        return Result.success(userOrderService.getUserOrders());
    }
}
