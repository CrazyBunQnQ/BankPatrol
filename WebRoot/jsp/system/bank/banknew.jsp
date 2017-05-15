<%@page import="com.bank.entity.Bank"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML >
<html>
<head>
<title>新增银行网点</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/base.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/check.js"></script>
</head>

<body>
	<div class="containner">
		<div id="inner-hd">
			<div class="crumbs">
				<span class="crumbs-label">系统管理&gt;&gt;银行网 点列表&gt;&gt;新增银行网点</span>
				</div>
		</div>
		<% Bank bank = (Bank)request.getAttribute("bank"); %>
		<div id="inner-bd">
			<form action="${pageContext.request.contextPath }/bank/bankAdd.do" method="post">
				<table class="kv-table">
					<tr>
						<td bgcolor="#F2F2F2" align="center" width="30%">银行编号</td>
						<td>
							<input type="text" name="bankId" onblur="checkBankId('bankId');" id="bankId"<% if (bank!=null) { %> value="${bank.id }"<% } %> placeholder="(字母或数字且长度小于10)"> <span id="show"></span>
						</td>
					</tr>
					<tr>
						<td bgcolor="#F2F2F2" align="center" width="30%">银行名称</td>
						<td>
							<input type="text" name="bankName"<% if (bank!=null) { %> value="${bank.name }"<% } %>>
						</td>
					</tr>
					<tr>
						<td bgcolor="#F2F2F2" align="center" width="30%">银行位置经度</td>
						<td>
							<input type="text" name="bankLongitude"<% if (bank!=null) { %> value="${bank.longitude }"<% } %>>
						</td>
					</tr>
					<tr>
						<td bgcolor="#F2F2F2" align="center" width="30%">银行位置纬度</td>
						<td>
							<input type="text" name="bankLatitude"<% if (bank!=null) { %> value="${bank.latitude }"<% } %>>
						</td>
					</tr>
					<tr>
						<td bgcolor="#F2F2F2" align="center" width="30%">银行IP</td>
						<td>
							<input type="text" name="bankIp"<% if (bank!=null) { %> value="${bank.ip }"<% } %> placeholder="(Ip格式:xxx.xxx.xxx.xxx)">
						</td>
					</tr>
				</table>
				<p align="center">
					<input type="submit" value="保存"> <input type="button" value="取消" onclick="history.back();">
				</p>
			</form>
		</div>
	</div>
</body>
</html>
