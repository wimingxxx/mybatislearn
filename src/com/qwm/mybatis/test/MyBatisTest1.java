package com.qwm.mybatis.test;


import com.qwm.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author: qiwenming(杞文明)
 * @date: 18/1/4 上午12:41
 * @className: MyBatisTest1
 * @description:
 * MyBatis测试
 */
public class MyBatisTest1 {
    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init() throws Exception{
        //1 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //2 加载SqlMapConfig.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        //3 创建SqlSessionFactory对象
        sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }


    @Test
    public void testQueryUserById(){
        //4 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //5 执行SqlSession对象执行查询，获取结果User
        // 第一个参数是User.xml的statement的id，第二个参数是执行sql需要的参数
        User user = sqlSession.selectOne("wiming.queryUserById",1);

        // 6. 打印结果
        System.out.println(user);

        // 7. 释放资源
        sqlSession.close();
    }

    //根据用户名称模糊查询用户信息
    @Test
    public void findUserByNameTest(){
        //4 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //5 执行SqlSession对象执行查询，获取结果User
        //可能多个数据，使用selectList
        List<User> list = sqlSession.selectList("wiming.findUserByName","明");

        // 6. 打印结果
        System.out.println(list);

        // 7. 释放资源
        sqlSession.close();
    }

    //根据用户名称模糊查询用户信息
    @Test
    public void insertUserTest(){
        //4 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //5 执行SqlSession对象执行插入
        User user = new User();
        user.setUsername("明哥哥1");
        user.setSex("1");
        user.setBirthday(new Date());
        user.setAddress("云南帝国");

        try{
            sqlSession.insert("wiming.insertUser",user);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 6. 释放资源
            sqlSession.close();
        }
    }

    //删除用户
    @Test
    public void deleteUserTest(){
        //4 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //5 执行SqlSession对象执行删除
        sqlSession.delete("wiming.deleteUser",30);
        sqlSession.commit();

        // 6. 释放资源
        sqlSession.close();
    }

    //更新用戶
    @Test
    public void updateUserTest(){
        //4 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //5 执行SqlSession对象执行插入
        User user = new User();
        user.setId(31);
        user.setUsername("明夜夜---");
        user.setSex("1");
        user.setBirthday(new Date());
        user.setAddress("云南帝国小xxx");

        try{
            sqlSession.insert("wiming.updateUser",user);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 6. 释放资源
            sqlSession.close();
        }
    }
}
