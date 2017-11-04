<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>选课系统</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/student.css" type="text/css">
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/student.js"></script>
</head>
<body>
<div class="pageTop">
    <div class="pageTop-ab">
        学生平台
    </div>
    <div id="welcome">
        欢迎你
        <span id ="name">${user.username}</span>
        今天是：

    </div>
</div>
<div class="pageItems">
    <ul>
        <li>
            <a href="${pageContext.request.contextPath}/users/submit">个人信息</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/course/allCourses">选课系统</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/users/course">学期成绩</a>
        </li>

    </ul>
</div>

<div id="pageCourse">
    <table class="tableMes" id="dataTables-example" align='center' style="border-collapse:collapse;float: left">
        <thead>
        <tr>

            <th>课程</th>
            <th>上课地点</th>
            <th>老师</th>
            <th>学分</th>
            <th>课程介绍</th>
            <th>选择</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="arrCourses" items="${arrCourses}">
        <tr>

            <td class="CourseId" id="${arrCourses.id}">${arrCourses.coursename}</td>
            <td>${arrCourses.address}</td>
            <td>${arrCourses.teacher}</td>
            <td>${arrCourses.credit}</td>
            <td>
                <div class="courseText" style="float: left;text-align: center">
                    <div class="courseData">
                        ${arrCourses.introduction}
                    </div>
                </div>
            </td>
            <td><input type="checkbox" style="width: 30px;height: 30px"/></td>
        </tr>
        </c:forEach>
        <tr>
            <td colspan="8"><input type="button" id="checkSubmit" value="提交"> </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>