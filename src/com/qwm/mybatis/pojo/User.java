package com.qwm.mybatis.pojo;

import java.io.Serializable;
import java.util.Date;

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

    @Override
    public String toString() {
        return "User{" +
                "address='" + address + '\'' +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
