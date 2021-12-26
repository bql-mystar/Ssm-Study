<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery.js"></script>
    <script>
        var userList = new Array();
        userList.push({"username":"zhangsan", "age":"18"});
        userList.push({"username":"zhaoliu", "age":"30"});
        $.ajax({
            url: "/user/quick15",
            data: JSON.stringify(userList),
            contentType:"application/json;charset=utf-8",
            type: "post"
        })
    </script>
</head>
<body>
</body>
</html>
