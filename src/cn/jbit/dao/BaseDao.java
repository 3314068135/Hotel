package cn.jbit.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author LiSheng
 * @create 2020-03-19 11:06
 * JDBC连接工具类
 */
public class BaseDao {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    static {
        try {
            InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("database.properties");
            Properties prop = new Properties();
            prop.load(is);
            driver =prop.getProperty("driver");
            url =prop.getProperty("url");
            username =prop.getProperty("username");
            password =prop.getProperty("password");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //获取连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    //增删改通用方法
    public static int executeUpdate(String sql,Object...params){
        Connection conn =null;
        PreparedStatement pstmt =null;
        int count = 0;
        try {
             conn = getConnection();
             pstmt = conn.prepareStatement(sql);
             if(params!=null&&params.length!=0){
                 for (int i = 0; i < params.length; i++) {
                     pstmt.setObject(i+1,params[i]);
                 }
             }
             count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(null,pstmt,conn);
        }
        return count;
    }

    //查询的通用方法
    public  static ResultSet executeQuery(String sql,Object...params){
        Connection conn =null;
        PreparedStatement pstmt =null;
        ResultSet rs =null;
        try {
             conn = getConnection();
             pstmt = conn.prepareStatement(sql);
            if(params!=null&&params.length!=0){
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i+1,params[i]);
                }
            }
             rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //释放资源
    public static void close(ResultSet rs, Statement stmt, Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
