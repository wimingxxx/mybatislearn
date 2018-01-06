package com.qwm.mybatis.dao.impl;

import com.qwm.mybatis.dao.IUserDao;
import com.qwm.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author：qiwenming
 * @date：2018/1/6 0006
 * @description：
 */
public class UserDaoImpl  implements IUserDao {


    private SqlSessionFactory sqlSessionFactory;

    /**
     * 将sqlSessionFactory注入
     * @param sqlSessionFactory
     */
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public User findUserById(int id) throws Exception {
        //创建Session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //查询
        User user = sqlSession.selectOne("wiming.findUserById",31);
        //关闭资源
        sqlSession.close();
        return user;
    }
}
