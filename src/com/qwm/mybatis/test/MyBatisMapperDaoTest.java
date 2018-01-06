package com.qwm.mybatis.test;

import com.qwm.mybatis.dao.IUserDao;
import com.qwm.mybatis.dao.impl.UserDaoImpl;
import com.qwm.mybatis.mapper.UserMapper;
import com.qwm.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author：qiwenming
 * @date：2018/1/6 0006
 * @description：
 */
public class MyBatisMapperDaoTest {
    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init() throws Exception {
        //1 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //2 加载SqlMapConfig.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        //3 创建SqlSessionFactory对象
        sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }

    /**
     * 根据id查询用户，使用Mapper方式
     */
    @Test
    public void findUserByIdDaoTest() throws Exception {
        //获取session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //查询
        User user = userMapper.findUserById(31);
        System.out.println(user);
    }

    /**
     * 根据用户名模糊查询用户，使用Mapper方式
     */
    @Test
    public void findUserByNameDaoTest() throws Exception {
        //获取session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //查询
        List<User> list = userMapper.findUserByName("小明");
        System.out.println(list);
    }
}
