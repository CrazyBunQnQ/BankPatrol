<%@page import="com.bank.entity.Bank"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML >
<html>
<head>
<title>修改银行网点</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/base.css">
</head>

<body>
	<div class="containner">
		<div id="inner-hd">
			<div class="crumbs">
				<span class="class="crumbs-label"">
					<a href="${pageContext.request.contextPath }/center.jsp">系统管理</a>&gt;&gt;
					<a href="${pageContext.request.contextPath }/bank/bankList.do">银行网点列表</a>&gt;&gt;
					修改银行网点
				</span>
			</div>
		</div>
		<% Bank bank = (Bank)request.getAttribute("bank"); %>
		<div id="inner-bd">
			<form action="${pageContext.request.contextPath }/bank/bankUpdate.do" method="post">
				<table class="kv-table">
					<tr>
						<td bgcolor="#F2F2F2" align="center" width="30%">银行编号</td>
						<td align="left" style="padding-left: 100px">
							<input type="text" name="bankId" value="${bank.id }" readonly><span id="show"><font color="red">不可修改银行 id</font></span>
						</td>
					</tr>
					<tr>
						<td bgcolor="#F2F2F2" align="center" width="30%">银行名称</td>
						<td align="left" style="padding-left: 100px">
							<input type="text" name="bankName" value="${bank.name }">
						</td>
					</tr>
					<tr>
						<td bgcolor="#F2F2F2" align="center" width="30%">银行位置经度</td>
						<td align="left" style="padding-left: 100px">
							<input type="text" name="bankLongitude" value="${bank.longitude }">
						</td>
					</tr>
					<tr>
						<td bgcolor="#F2F2F2" align="center" width="30%">银行位置纬度</td>
						<td align="left" style="padding-left: 100px">
							<input type="text" name="bankLatitude" value="${bank.latitude }">
						</td>
					</tr>
					<tr>
						<td bgcolor="#F2F2F2" align="center" width="30%">银行IP</td>
						<td align="left" style="padding-left: 100px">
							<input type="text" name="bankIp" value="${bank.ip }" placeholder="(Ip格式:xxx.xxx.xxx.xxx)">
						</td>
					</tr>
				</table>
				<p align="center">
					<input type="submit" value="修改"> <input type="button" value="取消" onclick="history.back();">
				</p>
			</form>
		</div>
	</div>
</body>
</html>
