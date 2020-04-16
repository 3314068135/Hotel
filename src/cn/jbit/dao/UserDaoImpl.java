package cn.jbit.dao;

import cn.jbit.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiehongjian
 * @create 2020-04-15 11:12
 */
public class UserDaoImpl implements UserDao {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    public User login(User user) {
        try {
            conn = BaseDao.getConnection();
            String sql = "select * from user where username=? and password=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            rs = pstmt.executeQuery();
            User user1 = null;
            if (rs.next()) {
                user1 = new User();
                user1.setId(rs.getInt("id"));
                user1.setUsername(rs.getString("username"));
                user1.setPassword(rs.getString("password"));
                user1.setRealname(rs.getString("realname"));
                user1.setPhone(rs.getString("phone"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean register(User user) {
        String sql = "insert into user values(?,?,?,?)";
        List<Object> list = new ArrayList<Object>();
        list.add(user.getUsername());
        list.add(user.getRealname());
        list.add(user.getPhone());
        list.add(user.getPassword());

        int flag = BaseDao.executeUpdate(sql, list.toArray());
        if (flag > 0) {
            return true;
        } else {
            return false;
        }
    }
}
