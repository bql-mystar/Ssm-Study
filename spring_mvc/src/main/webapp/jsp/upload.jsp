<%--
  Created by IntelliJ IDEA.
  User: 我秀任我秀
  Date: 2021/12/27
  Time: 0:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/user/quick21" method="post" enctype="multipart/form-data">
        姓名：<input type="text" name="name"><br>
        文件：<input type="file" name="file"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
