package com.springleaf.service;

import com.springleaf.pojo.Goods;
import com.springleaf.pojo.PageBean;

import java.util.List;

public interface GoodsService {
    //显示所有商品
    List<Goods> showGoods();

    //根据类型展示商品
    List<Goods> showTypeGoods(String type);

    //根据名称展示商品
    List<Goods> showNameGoods(String name);

    //添加商品
    void insertGoods(Goods goods);

    //删除商品
    void deleteGoods(Integer goodsId);

    //分页
    PageBean<Goods> list(Integer pageNum, Integer pageSize);
}
