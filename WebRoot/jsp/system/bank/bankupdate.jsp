<%@page import="com.bank.entity.Bank"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML >
<html>
<head>
<title>修改银行网点</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.css">
</head>

<body>
	<span class="sys_list_yh">系统管理&gt;&gt;银行网点管理&gt;&gt;修改银行网点</span>
	<% Bank bank = (Bank)request.getAttribute("bank"); %>
	<form action="${pageContext.request.contextPath }/bank/bankUpdate.do" method="post">
		<table align="center" border="1" width="60%">
			<tr>
				<td bgcolor="#F2F2F2" align="center" width="30%">银行编号</td>
				<td>
					<input type="text" name="bankId" value="${bank.id }" readonly><span id="show"><font color="red">不可修改银行 id</font></span>
				</td>
			</tr>
			<tr>
				<td bgcolor="#F2F2F2" align="center" width="30%">银行名称</td>
				<td>
					<input type="text" name="bankName" value="${bank.name }">
				</td>
			</tr>
			<tr>
				<td bgcolor="#F2F2F2" align="center" width="30%">银行位置经度</td>
				<td>
					<input type="text" name="bankLongitude" value="${bank.longitude }">
				</td>
			</tr>
			<tr>
				<td bgcolor="#F2F2F2" align="center" width="30%">银行位置纬度</td>
				<td>
					<input type="text" name="bankLatitude" value="${bank.latitude }">
				</td>
			</tr>
			<tr>
				<td bgcolor="#F2F2F2" align="center" width="30%">银行IP</td>
				<td>
					<input type="text" name="bankIp" value="${bank.ip }" placeholder="(Ip格式:xxx.xxx.xxx.xxx)">
				</td>
			</tr>
		</table>
		<p align="center">
			<input type="submit" value="修改"> <input type="button" value="取消" onclick="history.back();">
		</p>
	</form>
</body>
</html>
