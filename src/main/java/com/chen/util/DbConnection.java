package com.chen.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author: CHEN
 * @date: 2020-11-19 15:55
 * 获取数据库连接对象
 **/
public class DbConnection {
    Connection conn = null;
    public Connection getConn() throws ClassNotFoundException, SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC&characterEncoding=utf-8&useSSL=false"
                    ,"root","root");
            if(conn == null) {
                System.out.println("没连接成功");
            }
        }catch(Exception e) {
            System.out.println("有异常");
            e.printStackTrace();
        }
        return conn;
    }
}
