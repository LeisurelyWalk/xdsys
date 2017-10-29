<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/login.js"></script>
</head>
<body>
<input id="msg" type="hidden" value="${msg}">
<div style="height: 878px;width: 1920px">
    <div id ="ligo">
        <img src="${pageContext.request.contextPath}/img/xd.png">
    </div>
    <div id="content">
        <div id ="contain">

            <div id ="mainLogin">
                <p>账号:<input id ="name" type="text"></p>
                <p>密码:<input id ="password" type="text"></p>
            </div>
            <div id="login">
                <button id="submit">登录</button>
            </div>
        </div>
    </div>

</div>
</body>

</html>
