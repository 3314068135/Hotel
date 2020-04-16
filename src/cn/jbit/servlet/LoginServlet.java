package cn.jbit.servlet;

import cn.jbit.dao.UserDao;
import cn.jbit.dao.UserDaoImpl;
import cn.jbit.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xiehongjian
 * @create 2020-04-15 11:55
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        String name = request.getParameter("username");
        String pwd = request.getParameter("password");
        System.out.println(name + " " + pwd);
        user.setUsername(name);
        user.setPassword(pwd);

        UserDao userDao = new UserDaoImpl();
        User users = userDao.login(user);
        System.out.println(users);
        if (users != null) {
            request.setAttribute("info", "欢迎您，" + name + "！！！");
        } else {
            request.setAttribute("info", "登录失败。。。");
        }

        request.getRequestDispatcher("index/info.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
