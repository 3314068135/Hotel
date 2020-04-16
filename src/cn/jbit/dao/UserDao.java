package cn.jbit.dao;

import cn.jbit.pojo.User;

/**
 * @author xiehongjian
 * @create 2020-04-15 11:08
 */
public interface UserDao {
    /***
     * 用户登陆的方法声明
     * @param user
     * @return
     */
    public User login(User user);

    /***
     * 用户注册的方法声明
     * @param user
     * @return
     */
    public boolean register(User user);
}
