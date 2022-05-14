<%--
  Created by IntelliJ IDEA.
  User: 我秀任我秀
  Date: 2021/5/13
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addAccount</title>
</head>
<body>
    <div align="center">
        <form action="account/addStudent.do" method="get">
            id：<input type="text" name="id"> <br>
            name：<input type="text" name="name"> <br>
            balance：<input type="text" name="balance"> <br>
            <input type="submit" value="注册">
        </form>
    </div>
</body>
</html>
