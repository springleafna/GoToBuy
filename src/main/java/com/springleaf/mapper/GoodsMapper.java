package com.springleaf.mapper;

import com.springleaf.pojo.Goods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsMapper {
    @Select("select * from t_goods")
    List<Goods> showGoods();

    @Select("select * from t_goods where type like '%${type}%'")
    List<Goods> showTypeGoods(String type);

    @Select("select * from t_goods where name like '%${name}%'")
    List<Goods> showNameGoods(String name);

    @Insert("insert into t_goods(name, description, price, stock, type) values (#{name}, #{description}, #{price}, #{stock}, #{type})")
    void insertGoods(Goods goods);

    @Delete("delete from t_goods where goodsId = #{goodsId}")
    void deleteGoods(Integer goodsId);

}
