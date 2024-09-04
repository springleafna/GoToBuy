package com.springleaf.mapper;

import com.springleaf.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    //根据用户名查找用户
    @Select("select * from t_user where username=#{username}")
    User selectByUserName(String username);

    //根据用户ID查找用户
    @Select("select * from t_user where userId = #{userId}")
    User selectById(Integer userId);

    //添加用户
    @Insert("insert into t_user(username, password, type) values (#{username},#{password},1)")
    void insertUser(String username, String password);
}
