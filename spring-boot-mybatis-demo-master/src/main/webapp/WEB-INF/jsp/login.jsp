<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/system/user/indexpage"><h2>点击显示</h2></a>
	<form action="${pageContext.request.contextPath}/ajaxLogin" method="post">
		账号：<input type="text" id="nickname" name="nickname" /> 
		密码：<input type="text" id="pswd" name="pswd" /> 
		 <input type="submit">
	</form>

</body>
</html>