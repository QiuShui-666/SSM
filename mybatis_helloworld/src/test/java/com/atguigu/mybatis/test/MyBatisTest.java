package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    @Test
    public void testInsert() throws IOException {
        // 获取核心配置文件的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取 SqlSessionFactoryBuilder 对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 获取 SqlSessionFactory 对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
//        // 获取 sql 的会话对象 （SqlSession 不会自动提交事务），是 MyBatis 提供的操作数据的对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取 sql 的会话对象 （SqlSession 会自动提交事务），是 MyBatis 提供的操作数据的对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 获取 UserMapper 的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 调用 mapper 接口中的方法，实现添加用户信息的功能
        int result = mapper.insertUser();
//        int result = sqlSession.insert("com.atguigu.mybatis.mapper.UserMapper.insertUser");
        System.out.println("结果：" + result);
//        // 提交事务
//        sqlSession.commit();
        // 关闭 SqlSession 对象
        sqlSession.close();
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
        sqlSession.close();
    }

    @Test
    public void testDelete() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();
        sqlSession.close();
    }


    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById();
        System.out.println(user);
    }

    @Test
    public void testGetAllUser() {
        UserMapper mapper = SqlSessionUtil.getUserMapper();
        List<User> users = mapper.getAllUser();
        users.forEach(System.out::println);
    }

}
