<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人界面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/student.css" type="text/css">
</head>
<body>
<div class="dataTable">
    <table class="tableMes" id="dataTables-example">
        <thead>
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>地址</th>
        </tr>
        </thead>
        <tbody>
        <tr>
                <td>${user.numid}</td>
                <td>${user.username}</td>
                <td>${user.sex=='1'?'女':'男'}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
            </tr>
        </tbody>
    </table>

</div>
</body>
</html>