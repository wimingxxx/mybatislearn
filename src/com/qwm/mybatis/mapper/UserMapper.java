package com.qwm.mybatis.mapper;

import com.qwm.mybatis.pojo.User;
import com.qwm.mybatis.pojo.UserCustom;
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

    /**
     * 查询用户及其订单和订单明细，关联商品的信息
     * @return
     * @throws Exception
     */
    List<User> findUserOrDetails() throws Exception;

    /**
     * 多对多查询：查询显示字段：用户账号、用户名称、用户性别、商品名称、商品价格(最常见
     * @return
     * @throws Exception
     */
    List<UserCustom> findUserOrItems() throws Exception;
}
