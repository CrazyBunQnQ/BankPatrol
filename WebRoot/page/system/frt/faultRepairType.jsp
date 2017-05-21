<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>设备报修问题展现</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/base.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jump.js"></script>
</head>

<body>
	<div class="containner">
		<div id="inner-hd">
			<div class="crumbs">
				<a href="javascript:;" class="crumbs-label">系统管理&gt;&gt;设备报修问题列表</a>
			</div>
		</div>
		<div id="inner-bd">
			<div class="button-group">
				<div class="button">
					<img src="${pageContext.request.contextPath}/images/add.gif"
						onclick="location.href='../frt/toRepairTypeAdd'">
				</div>
				<div class="button">
					<img src="${pageContext.request.contextPath}/images/search1.gif"
						onclick="openfind();">
				</div>
			</div>
			<div id="find" style="display: none">
				<form action="../frt/faultRepairType" method="post">
					<table>
						<tr>
							<td>设备类型：</td>
							<td><input name="searchrepairTypeValue" type="text" value=""></td>
							<td><input type="image"
								src="${pageContext.request.contextPath }/images/search1.gif"
								class="input_button9" title="搜索" /></td>
						</tr>
					</table>
				</form>
			</div>
			<table class="kv-table">
				<thead>
					<tr>
						<td class="kv-num">问题编号</td>
						<td class="kv-name">问题名称</td>
						<td class="kv-handle">操作</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${data.pageData}" var="repairTypeValue">
						<tr>
							<td>${repairTypeValue.id }</td>
							<td>${repairTypeValue.value }</td>
							<td>
								<div class="handle">
									<span class="handle-icon del" onclick="delRepairType(${repairTypeValue.id })"></span>
									<a href="../frt/repairType2Update?repairTypeValue=${repairTypeValue.id}"><span
										class="handle-icon fix"></span></a>
								</div>
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
			<font color="black">项&nbsp;</font> <font color="black">每页</font> <font
				color="black">${data.pageSize }</font><font color="black">项&nbsp;</font>
			<font color="black">当前第</font><font color="black">${data.curPage }</font>
			<font color="black">页&nbsp;</font> <font color="black">共</font> <font
				color="black">${data.totalPage }</font> <font color="black">页&nbsp;
			</font>

			<c:if test="${data.curPage!=1 }">
				<a href="../dept/faultRepairType?curpage=${data.curPage-1 }">上一页</a>
				<a href="../dept/faultRepairType?curpage=1 ">首 页</a>
			</c:if>
			<c:if test="${data.curPage!=data.totalPage }">
				<a
					href="../frt/faultRepairType?curpage=${data.curPage+1 }&loginId=${log}&userName=${un}">下一页</a>
				<a href="../frt/faultRepairType?curpage=${data.totalPage }">尾 页</a>
			</c:if>
			第<input id="pagebox" type="text" size="4">页 <a
				onclick="jump('../frt/faultRepairType?curpage=','${data.totalPage }');"
				href="javascript:;">跳转</a>
		</p>
	</div>
</body>
<script>
	function delRepairType(id){
		if(confirm("确定要删除吗？")){
			window.location.href="${pageContext.request.contextPath}/frt/RepairTypeDelete?RepairTypeId="+id;
		}
	}
</script>
</html>