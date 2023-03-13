package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {

    /**
     * 添加用户信息
     * @return 1 成功；其他 不成功
     */
    int insertUser();


    /**
     * 修改用户的信息
     */
    void updateUser();

    /**
     * 删除用户的信息
     */
    void deleteUser();

    /**
     * 根据 id 查询用户信息
     * @return User
     */
    User getUserById();


    /**
     * 查询所有用户的信息
     * @return List<User>
     */
    List<User> getAllUser();

}
