package com.qwm.mybatis.test;

import com.qwm.mybatis.dao.IUserDao;
import com.qwm.mybatis.dao.impl.UserDaoImpl;
import com.qwm.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class MyBatisDaoTest {
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

    /**
     * 根据id查询用户，使用原始的dao
     */
    @Test
    public void findUserByIdDaoTest() throws Exception {
        IUserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = userDao.findUserById(31);
        System.out.println(user);
    }
}
