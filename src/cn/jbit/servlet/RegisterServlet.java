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
 * @create 2020-04-15 15:23
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        String name = request.getParameter("username");
        String realname = request.getParameter("realname");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        user.setUsername(name);
        user.setRealname(realname);
        user.setPhone(phone);
        user.setPassword(password);

        UserDao userDao = new UserDaoImpl();
        boolean flag = userDao.register(user);
        if(flag){
            request.setAttribute("info", "注册成功！！！");
        }else{
            request.setAttribute("info", "注册失败。。。");
        }

        request.getRequestDispatcher("/index/info.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
