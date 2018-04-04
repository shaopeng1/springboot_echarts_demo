<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息录入</title>
<script type="text/javascript"src="${pageContext.request.contextPath}/js/jquery-1.4.2.js"></script>
<script type="text/javascript"src="${pageContext.request.contextPath}/js/echarts.js"></script>
<script src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script>

</head>
<body>
<shiro:authenticated>用户已经登录显示此内容<br/></shiro:authenticated><br/>
 <shiro:hasRole  name="admin">我是管理员</shiro:hasRole> 
 <shiro:hasRole name="normal">normal角色登录显示此内容<br/></shiro:hasRole><br/>
 权限1： ${user }

</body>
</html>