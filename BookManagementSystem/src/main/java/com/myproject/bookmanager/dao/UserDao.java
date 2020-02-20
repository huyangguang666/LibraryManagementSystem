package com.myproject.bookmanager.dao;

import com.myproject.bookmanager.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserDao {

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Insert("insert into user(name,email,password) values(#{name},#{email},#{password})")
    int addUser(User user);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    User selectById(Integer id);

    /**
     * 根据名称查询用户信息
     * @param name
     * @return
     */
    @Select("select * from user where name=#{name}")
    User selectByName(String name);

    /**
     * 根据邮件查询邮件
     * @param email
     * @return
     */
    @Select("select * from user where email=#{email}")
    User selectByEmail(String email);

    /**
     * 更改用户密码
     * @param user
     */
    @Update("update user set password=#{password} where id=#{id}")
    void updatePassword(User user);
}
