<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>修改设备报修问题</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/main.css">
</head>
<body>
	<span class="sys_list_yh">系统管理&gt;&gt;设备报修问题列表&gt;&gt;修改设备报修问题</span>
	<form action="" method="post">
		<table align="center" border="1" width="60%">
			<tr>
				<td bgcolor="#F2F2F2" align="center" width="30%">问题编号</td>
				<td><input name="faultRepairType.pitypeId" value="001"
					readonly="readonly"></td>
			</tr>
			<tr>
				<td bgcolor="#F2F2F2" align="center" width="30%">问题名称</td>
				<td><input name="faultRepairType.pitypeValue" value="机器不吐钞"></td>
			</tr>
		</table>
		<p align="center">
			<input type="submit" value="提交"> <input type="button"
				value="返回" onclick="history.back();">
		</p>
	</form>
</body>
</html>