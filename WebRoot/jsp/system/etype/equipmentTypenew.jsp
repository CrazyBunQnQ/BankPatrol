<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML >
<html>
<head>
<title>银行设备种类管理列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/check.js"></script>
</head>

<body>
	<span class="sys_list_yh">系统管理&gt;&gt;银行设备种类管理列表&gt;&gt;新增银行设备种类管理</span>
	<form action="${pageContext.request.contextPath }/etype/addEType.do" method="post" onsubmit="return checkdata();">
		<table align="center" border="1" width="75%">
			<tr>
				<td bgcolor="#F2F2F2" align="center" width="30%">设备种类ID</td>
				<td>
					<input type="text" name="eTypeId" onblur="checkEquipmentTypeId('eTypeId');" id="eTypeId" value="${eType.id }" placeholder="(非汉字且长度小于10位)">
					<span id="show"></span>
				</td>
			</tr>

			<tr>
				<td bgcolor="#F2F2F2" align="center" width="30%">设备名称</td>
				<td>
					<input type="text" name="eTypeName" onchange="checkEquipmentName('eTypeName')" id="eTypeName" value="${eType.name }">
					<span id="show1"></span>
				</td>
			</tr>
		</table>
		<p align="center">
			<input type="submit" value="保存"> <input type="button" value="返回" onclick="history.back();">
		</p>
	</form>
</body>
</html>
