<%--
  Created by IntelliJ IDEA.
  User: 80953
  Date: 2019/4/13
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>自制登录页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/j_spring_security_check" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"/></td>
        </tr>

        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"/></td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="登录"/>
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
