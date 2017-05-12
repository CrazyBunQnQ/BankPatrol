<%@page import="com.bank.entity.BankEquipment"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML >
<html>
<head>
<title>修改银行设备明细</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/lib/My97DatePicker/WdatePicker.js"></script>
</head>

<body>
	<span class="sys_list_yh">系统管理&gt;&gt;银行设备明细列表&gt;&gt;修改银行设备明细</span>
	<% BankEquipment equi = (BankEquipment)request.getAttribute("equi"); %>
	<form action="${pageContext.request.contextPath }/bank/UpdateEquipment.do" method="post">
		<table align="center" border="1" width="60%">
			<tr>
				<td bgcolor="#F2F2F2" align="center" width="30%">设备流水ID</td>
				<td><input type="text" name="equipmentEachId" value="${equi.eachID }" readonly></td>
			</tr>
			<tr>
				<td bgcolor="#F2F2F2" align="center" width="30%">所属种类名</td>
				<td>
					<select name="equipmentId">
						<c:forEach items="${typs }" var="type">
							<option value="${type.id }">${type.name }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td bgcolor="#F2F2F2" align="center" width="30%">所在银行</td>
				<td>
					<input type="text" name="bankName" value="${equi.bank.name }" readonly>
					<input type="hidden" name="bankId" value="${equi.bank.id }">
				</td>
			</tr>
			<tr>
				<td bgcolor="#F2F2F2" align="center" width="30%">购入价值</td>
				<td><input type="text" name="equipmentValue" value="${equi.value }"
					readonly></td>
			</tr>
			<tr>
				<td bgcolor="#F2F2F2" align="center" width="30%">购入时间</td>
				<td><input name="equipmentBuyDate" value="${equi.getBuyDateStr() }" onClick="WdatePicker();" readonly>

				</td>
			</tr>
			<tr>
				<td bgcolor="#F2F2F2" align="center" width="30%">设备状态</td>
				<td><select name="status">
						<option value="0"<% if (equi!=null && equi.getStatus()==0) { %> selected<% } %>>设备正常</option>
						<option value="1"<% if (equi!=null && equi.getStatus()==1) { %> selected<% } %>>报检设备</option>
						<option value="2"<% if (equi!=null && equi.getStatus()==2) { %> selected<% } %>>停用设备</option>
				</select></td>
			</tr>
			<tr>
				<td bgcolor="#F2F2F2" align="center" width="30%">设备折旧残值</td>
				<td><input type="text" name="depreciationValue" value="${equi.depreciationValue }"></td>
			</tr>
		</table>
		<p align="center">
			<input type="submit" value="提交"> <input type="button" value="取消" onclick="history.back();">
		</p>
	</form>
</body>
</html>
