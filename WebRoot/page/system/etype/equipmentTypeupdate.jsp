<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML >
<html>
<head>
<title>设备更新页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/base.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/check.js"></script>
</head>

<body>
	<div class="containner">
		<div id="inner-hd">
			<div class="crumbs">
				<span class="crumbs-label">系统管理&gt;&gt;银行设备种类管理列表&gt;&gt;修改银行设备种类管理</span>
			</div>
		</div>
		<div id="inner-bd">
			<form action="${pageContext.request.contextPath }/etype/updateEType" method="post">
				<table class="kv-table">
					<tr>
						<td bgcolor="#F2F2F2" align="center" width="30%">设备种类ID</td>
						<td align="left" style="padding-left: 100px"><input type="text" name="eTypeId" value="${eType.id }" readonly></td>
					</tr>
					<tr>
						<td bgcolor="#F2F2F2" align="center" width="30%">设备名称</td>
						<td align="left" style="padding-left: 100px">
							<input type="text" name="eTypeName" onblur="checkEquipmentName('eTypeName');" id="eTypeName" value="${eType.name }">
							<span id="show1"></span>
						</td>
					</tr>
				</table>
				<p align="center">
					<input type="submit" value="修改"> <input type="button" value="返回" onclick="history.back();">
				</p>
			</form>
		</div>
	</div>
</body>
</html>
