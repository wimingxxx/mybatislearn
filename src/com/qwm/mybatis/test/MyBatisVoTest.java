package com.qwm.mybatis.test;

import com.qwm.mybatis.mapper.UserMapper;
import com.qwm.mybatis.pojo.User;
import com.qwm.mybatis.pojo.UserCustom;
import com.qwm.mybatis.pojo.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author：qiwenming
 * @date：2018/1/7 0007
 * @description：
 */
public class MyBatisVoTest {
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
    public void findUserListTest() throws Exception {
        //获取session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //创建查询条件
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setUsername("小明");
        userQueryVo.setUserCustom(userCustom);
        //查询
        List<User> list = userMapper.findUserList(userQueryVo);
        System.out.println(list);
    }

    /**
     * 根据ids查询用户，使用Mapper方式
     */
    @Test
    public void findUserListTest2() throws Exception {
        //获取session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //创建查询条件
        UserQueryVo userQueryVo = new UserQueryVo();
        List<Integer> ids = new ArrayList<>();
        ids.add(16);
        ids.add(22);
        userQueryVo.setIds(ids);
        //查询
        List<User> list = userMapper.findUserList(userQueryVo);
        System.out.println(list);
    }
}
