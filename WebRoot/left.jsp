<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>商业银行巡检系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/base.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/platform.css">
</head>

<body>

	<ul class="sider-nav">
		<h2 style="padding: 0 20px; height: 42px; line-height: 42px; color: #fff;">
			<span class="pf-sider-icon"></span> <span class="pf-name">${funName}</span>
		</h2>
		<c:forEach items="${leftList }" var="x">
			<li class="current">
				<a href="${pageContext.request.contextPath }/${x.url }" target="mainfre">
					<img src="images/square1.png"><span class="sider-nav-title">${x.name}</span>
				</a>
			</li>
		</c:forEach>
	</ul>

</body>
</html>
