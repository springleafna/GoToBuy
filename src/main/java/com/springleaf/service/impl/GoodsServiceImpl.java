package com.springleaf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springleaf.mapper.GoodsMapper;
import com.springleaf.pojo.Goods;
import com.springleaf.pojo.PageBean;
import com.springleaf.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    @Override
    public List<Goods> showGoods() {
        return goodsMapper.showGoods();
    }

    @Override
    public List<Goods> showTypeGoods(String type) {
        return goodsMapper.showTypeGoods(type);
    }

    @Override
    public List<Goods> showNameGoods(String name) {
        return goodsMapper.showNameGoods(name);
    }

    @Override
    public void insertGoods(Goods goods) {
        goodsMapper.insertGoods(goods);
    }

    @Override
    public void deleteGoods(Integer goodsId) {
        goodsMapper.deleteGoods(goodsId);
    }

    @Override
    public PageBean<Goods> list(Integer pageNum, Integer pageSize) {
        //1.创建PageBean对象，用来封装查询到的数据
        PageBean<Goods> pb = new PageBean<>();

        //2.开启分页查询  PageHelper 需要导入坐标
        PageHelper.startPage(pageNum, pageSize);

        //3.调用mapper完成查询
        List<Goods> as = goodsMapper.showGoods();
        //Page中提供了方法，可以获取PageHelper分页查询后得到的总记录条数和当前页数据
        Page<Goods> p = (Page<Goods>) as;

        //把数据填充到PageBean对象中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

}
