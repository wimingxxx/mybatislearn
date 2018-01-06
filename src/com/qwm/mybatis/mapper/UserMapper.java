package com.qwm.mybatis.mapper;

import com.qwm.mybatis.pojo.User;
import com.qwm.mybatis.pojo.UserQueryVo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author：qiwenming
 * @date：2018/1/6 0006
 * @description：
 */
public interface UserMapper {
    /**
     * 根据用户id查询用户
     * @param id
     * @return
     * @throws Exception
     */
    public User findUserById(int id) throws Exception;

    /**
     * 根据用户名模糊匹配查询用户
     * @param name
     * @return
     * @throws Exception
     */
    public List<User> findUserByName(String name) throws Exception;

    /**
     * 根据包装类查询用户信息
     * @param userQueryVo
     * @return
     * @throws Exception
     */
    public List<User> findUserList(UserQueryVo userQueryVo) throws Exception;
}
