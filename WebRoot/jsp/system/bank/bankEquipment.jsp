<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/base.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jump.js"></script>
<title>银行设备明细</title>
</head>

<body>
	<div class="containner">
		<div id="inner-hd">
			<div class="crumbs">
				<a href="javascript:;" class="crumbs-label">系统管理&gt;&gt;银行设备明细列表</a>
			</div>
		</div>
		<div id="inner-bd">
			<div class="button-group">
				<div class="button">
					<img src="${pageContext.request.contextPath }/images/add.gif" onclick="location.href='../bank/toAddEquipment.do?bankId=${bankId }'">
				</div>
			</div>
			<table class="kv-table">
				<thead>
					<tr>
						<td>设备流水ID</td>
						<td>银行编号ID</td>
						<td>设备种类ID</td>
						<td>购入价格</td>
						<td>购入时间</td>
						<td>设备状态</td>
						<td>设备折旧残值</td>
						<td>操作</td>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${data.pageData }" var="equipment">
						<tr>
							<td>${equipment.eachID }</td>
							<td>${BankId }</td>
							<td>${equipment.getTypeId() }</td>
							<td>${equipment.value }</td>
							<td>${equipment.getBuyDateStr() }</td>
							<td>${equipment.getStatusStr() }</td>
							<td>${equipment.depreciationValue }</td>
							<td>
								<div class="handle"><span class="handle-icon fix"></span></div>
								<div class="handle"><span class="handle-icon del"></span></div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div>
		<p align="right">
			<font color="black">共</font><font color="black">${data.totalRecord}</font>
			<font color="black">项&nbsp;</font> <font color="black">每页</font>
			<font color="black">${data.pageSize }</font><font color="black">项&nbsp;</font>
			<font color="black">当前第</font><font color="black">${data.curPage }</font>
			<font color="black">页&nbsp;</font> <font color="black">共</font>
			<font color="black">${data.totalPage }</font> <font color="black">页&nbsp;
			</font>
	
			<c:if test="${data.curPage!=1 }">
				<a href="../bank/bankList.do?curpage=${data.curPage-1 }">上一页</a>
				<a href="../bank/bankList.do?curpage=1 ">首 页</a>
			</c:if>
			<c:if test="${data.curPage!=data.totalPage }">
				<a href="../bank/bankList.do?curpage=${data.curPage+1 }&loginId=${log}&userName=${un}">下一页</a>
				<a href="../bank/bankList.do?curpage=${data.totalPage }">尾 页</a>
			</c:if>
			第<input id="pagebox" type="text" size="4">页
			<a onclick="jump('../bank/EquipmentsList.do?curpage=','${data.totalPage }');" href="javascript:;">跳转</a>
		</p>
	</div>
</body>
</html>