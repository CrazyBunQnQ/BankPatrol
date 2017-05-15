<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML >
<html>
<head>

<title>用户新增</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="${pageContext.request.contextPath }/css/base.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/checkUserName.js"></script>
</head>

<body>
	<div class="containner">
		<div id="inner-hd">
			<div class="crumbs">
				<span class="crumbs-label">
					<a href="${pageContext.request.contextPath }/center.jsp">系统管理</a>&gt;&gt;
					<a href="${pageContext.request.contextPath }/user/userList.do">用户管理</a>&gt;&gt;
					用户新增
				</span>
			</div>
		</div>
		<div id="inner-bd">
			<form action="${pageContext.request.contextPath }/user/userAdd.do" method="post" onsubmit="return checkdata();">
				<table class="kv-table">
					<tr bgcolor="#F2F2F2">
						<td width="30%">用户登陆ID</td>
						<td>
							<input type="text" id="loginId" name="loginId" class="input" onblur="searchSuggest(this.id,'msg');">
							<font id="msg">(只能是字母和数字长度不能大于10)</font><span id="title"></span>
						</td>
					</tr>
					<tr bgcolor="#F2F2F2">
						<td>用户登陆密码</td>
						<td><input type="password" id="pwd" class="input"></td>
					</tr>
					<tr bgcolor="#F2F2F2">
						<td>确认密码</td>
						<td><input type="password" id="checkpwd" name="checkpwd" class="input"></td>
					</tr>
					<tr bgcolor="#F2F2F2">
						<td>用户中文名称</td>
						<td><input type="text" name="userName"></td>
					</tr>
					<tr bgcolor="#F2F2F2">
						<td>用户所属部门</td>
						<td>
							<select name='dept'>
								<c:forEach items="${ d }" var="d1">
									<option value="${d1.id }">${d1.name }</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr bgcolor="#F2F2F2">
						<td>用户所在岗位</td>
						<td>
							<select name='job'>
								<c:forEach items="${ j }" var="j1">
									<option value="${j1.id }">${j1.name }</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr bgcolor="#F2F2F2">
						<td>用户状态</td>
						<td>
							<input type="radio" name="userStatus" value="1" checked>启用
							<input type="radio" name="userStatus" value="0">禁用
						</td>
					</tr>
					<tr bgcolor="#F2F2F2">
						<td colspan="2" align="center"><input type="submit" value="新增">
							<input type="button" value="取消" onclick="history.back();">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>