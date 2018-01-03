package com.qwm.mybatis.test;

import org.junit.Test;

import java.sql.*;

/**
 * @author: qiwenming(杞文明)
 * @date: 18/1/3 下午11:24
 * @className: JDBCTest
 * @description:
 *  JDBC测试
 */
public class JDBCTest {

    /**
     * jdbc 测试
     */
    @Test
    public void test1(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");

            //通过驱动管理类获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8","root","xm123456");

            //定义sql ? 表示占位符
            String sql = "select * from user where username = ?";

            //获取预处理 statement
            preparedStatement = connection.prepareStatement(sql);

            //设置参数,第一个参数为sql语句中参数需要(从1开始),第二个参数为设置的参数值
            preparedStatement.setString(1,"张三");

            //向数据库发出sql执行查询,查询出结果集
            resultSet = preparedStatement.executeQuery();

            //遍历结果集
            while (resultSet.next()){
                StringBuilder sb = new StringBuilder();
                sb.append("id : " + resultSet.getString("id") + "  ,  ");
                sb.append("username : " + resultSet.getString("username") + "  ,  ");
                sb.append("birthday : " + resultSet.getString("birthday") + "  ,  ");
                sb.append("sex : " + resultSet.getString("sex") + "  ,  ");
                sb.append("address : " + resultSet.getString("address"));
                System.out.println(sb.toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放资源
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
