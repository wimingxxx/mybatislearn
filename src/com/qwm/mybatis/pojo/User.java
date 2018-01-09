package com.qwm.mybatis.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: qiwenming(杞文明)
 * @date: 18/1/4 上午12:30
 * @className: User
 * @description:
 */
public class User implements Serializable {
    private int id;//id
    private String username;//用户名
    private String sex;//性别
    private Date birthday;//生日
    private String address;//地址
    private List<ItemsCustom> itemsCustoms;
    //多个订单
    private List<Orders> orderslist;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<ItemsCustom> getItemsCustoms() {
        return itemsCustoms;
    }

    public void setItemsCustoms(List<ItemsCustom> itemsCustoms) {
        this.itemsCustoms = itemsCustoms;
    }

    public List<Orders> getOrderslist() {
        return orderslist;
    }

    public void setOrderslist(List<Orders> orderslist) {
        this.orderslist = orderslist;
    }
}
