package com.springleaf.controller;

import com.springleaf.pojo.Goods;
import com.springleaf.pojo.PageBean;
import com.springleaf.common.Result;
import com.springleaf.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @GetMapping
    public Result<List<Goods>> showGoods(){
        return Result.success(goodsService.showGoods());
    }

    @GetMapping("/type")
    public Result<List<Goods>> showTypeGoods(String type){
        return Result.success(goodsService.showTypeGoods(type));
    }

    @GetMapping("/name")
    public Result<List<Goods>> showNameGoods(String name){
        return Result.success(goodsService.showNameGoods(name));
    }
    
    @PostMapping
    public Result insertGoods(@RequestBody Goods goods){
        goodsService.insertGoods(goods);
        return Result.success();
    }

    @DeleteMapping
    public Result deleteGoods(Integer goodsId){
        goodsService.deleteGoods(goodsId);
        return Result.success();
    }

    //分页
    @GetMapping("/list")
    public Result<PageBean<Goods>> list(Integer pageNum, Integer pageSize) {
        PageBean<Goods> pb =  goodsService.list(pageNum, pageSize);
        return Result.success(pb);
    }
}
