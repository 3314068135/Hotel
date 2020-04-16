<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/4/14
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link href="css/login.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
    <div id="top">

    </div>
    <div id="loginframe">
        <form action="/LoginServlet" method="post">
            <table align="center">
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>
                        <p>&nbsp;</p>
                        <p id="bigfont">登录</p>
                        <p>&nbsp;</p>
                        <p>账号</p>
                        <p><input type="text" name="username" placeholder="&nbsp;用户名"/></p>
                        <p>&nbsp;</p>
                        <p>密码</p>
                        <p><input type="password" name="password" placeholder="&nbsp;密码"/></p>
                        <p>&nbsp;</p>
                        <p>用户类型</p>
                        <p style="border:1px solid blue; position:absolute; overflow:hidden">
                            <select style="margin:-1px">
                                <option value ="1" selected="selected">请输入用户类型</option>
                                <option value ="2">管理员</option>
                                <option value ="3">住户</option>
                            </select>
                        </p>
                        <p>&nbsp;</p>
                        <p>&nbsp;</p>
                        <p>&nbsp;</p>
                        <p>
                            <button type="button">登录</button>
                        </p>
                    </td>
                </tr>
            </table>
        </form>
    </div>
  </body>
</html>
