<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML >
<html>
	<head>

		<title>巡检工添加页面</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/css.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jump.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/check.js"></script>
	</head>
	<body topmargin="50">	 
	 
	<div id="inner-hd">
			<div class="crumbs">
				<a href="javascript:;" class="crumbs-label">系统管理&gt;&gt;巡检工列表&gt;&gt;新增巡检工</a>
			</div>
		</div>	
	   
		<form action="../piwoker/addPiworker" method="post" onsubmit="return checkTel();">
			<table width="60%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#E4E4E4">
					<tr bgcolor="#F2F2F2">
					<td  align="center">巡检工id：</td>
					<td><input name="workerId" onblur="checkPiWorkerId('workerId')" id="workerId"><span id="show"></span></td>
					</tr>
					<tr bgcolor="#F2F2F2">
					<td  align="center">巡检小组：</td>
					<td>
					<select style="width: 157px;" name="groupId">
						<c:forEach items="${groups}" var="group">
							<option value="${group.id}" >${group.name}</option>
						</c:forEach>
					</select></td>
					</tr>
				    <tr bgcolor="#F2F2F2">
					<td  align="center">电话1：</td>
					<td><input name="workerTel1" id="tel" onblur="checkTel('tel')"></td>
					</tr>
					<tr bgcolor="#F2F2F2">
					<td  align="center">电话2：</td>
					<td><input name="workerTel2" id="te2" onblur="checkTel('te2')"></td>
					</tr>
			
			</table><br>
			<center><input type="submit" value="提交">&nbsp;&nbsp;<input type="button" value="返回" onclick="history.back();"></center>
		</form>
	</body>
</html>

