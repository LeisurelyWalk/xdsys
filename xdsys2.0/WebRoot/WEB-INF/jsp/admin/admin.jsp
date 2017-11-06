<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>管理系统</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/student.css" type="text/css">
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/admin.js"></script>
</head>
<body>
<div class="pageTop">
    <div class="pageTop-ab">
        管理系统
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
            <a href="${pageContext.request.contextPath}/users/submit">添加课程</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/course/allCourses">修改成绩</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/users/course">录入学生</a>
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
        
        </tr>
        </c:forEach>
            <tr>
                <td colspan="5"><input type="button" id="courseSubmit" value="添加"> </td>
            </tr>
        </tbody>
    </table>
</div>
<div id="newCourses" style="display: none; position: fixed;width: 300px;height: 400px;background-color: aquamarine;left: 30%;font-family: 'Microsoft YaHei'">
    <div id="top" style="position: relative; width: 100%;height: 50px;background-color: cornsilk;text-align: center;">
        <div style="width: 300px;height: 50px;vertical-align: middle;display: table-cell;margin: 0px auto;">新建课程</div>
    </div>
    <form role="form" action="${pageContext.request.contextPath}/course/courseSubmit" method="post">
    <div id="pageMes" style="width: 300px;height: 300px;background-color:blue">
    
    <div style="padding: 20px 0px;vertical-align: middle">
        <p>课程名称 <input type="text" class="courseInput" id="coursename" name="coursename"></p>
        <p>&nbsp;&nbsp;&nbsp;学分 &nbsp;&nbsp;&nbsp; <input type="text" class="courseInput" id="credit" name="credit"></p>
        <p>&nbsp;&nbsp;&nbsp;老师 &nbsp;&nbsp;&nbsp; <input type="text" class="courseInput" id="teacher" name="teacher"></p>
        <p>上课地点 <input type="text" class="courseInput" id="address" name="address"></p>
        <p>课程介绍 <input type="text" class="courseInput" id="introduction" name="introduction"></p>
    </div>
    
  	
    </div>
    <div id="bottom" style="position: relative;width: 300px;height: 50px;background-color: chocolate">
		<div id="login">
               <input id="submit" type="submit"></input>
         </div>
    </div>
    </form>
</div>
</body>
</html>