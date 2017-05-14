<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML >
<html>
<head>

<title>银行设备种类管理展现</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/base.css">
</head>

<body>
	<div class="containner">
		<div id="inner-hd">
			<div class="crumbs">
				<a href="javascript:;" class="crumbs-label">系统管理&gt;&gt;银行设备种类管理列表</a>
			</div>
		</div>
		<div id="inner-bd">
			<div class="button-group">
				<div class="button">
					<img src="${pageContext.request.contextPath }/images/add.gif" onclick="location.href='../etype/toAdd.do'">
				</div>
				<div class="button">
					<img src="${pageContext.request.contextPath }/images/search1.gif" onclick="location.href='../etype/equipmentTypeList.do?ename='">
				</div>
			</div>
			<table class="kv-table">
				<thead>
					<tr>
						<td class="kv-num">设备种类ID</td>
						<td class="kv-name">设备种类名称</td>
						<td class="kv-handle">操作</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${data.pageData }" var="type">
						<tr>
							<td>${type.id }</td>
							<td>${type.name }</td>
							<td>
								<div class="handle">
									<span class="handle-icon fix"></span>
									<c:if test="${!type.hasEq }">
										<span class="handle-icon del"></span>
									</c:if>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div>
		<p align="right" style="margin: 10px 24px 0px 0px">
			<font color="black">共&nbsp;</font><font color="black">${data.totalRecord}</font><font color="black">项&nbsp;&nbsp;</font>
			<font color="black">每页&nbsp;</font><font color="black">${data.pageSize }</font><font color="black">&nbsp;项&nbsp;&nbsp;</font>
			<font color="black">当前第&nbsp;</font><font color="black">${data.curPage }</font><font color="black">&nbsp;页&nbsp;&nbsp;</font>
			<font color="black">共&nbsp;</font><font color="black">${data.totalPage }</font><font color="black">&nbsp;页&nbsp;&nbsp;</font>
	
			<c:if test="${data.curPage!=1 }">
				<a href="../equipmentType/equipmentTypeList.do?curpage=${data.curPage-1 }">上一页</a>&nbsp;&nbsp;
				<a href="../equipmentType/equipmentTypeList.do?curpage=1 ">首 页</a>&nbsp;&nbsp;
			</c:if>
			<c:if test="${data.curPage!=data.totalPage }">
				<a href="../equipmentType/equipmentTypeList.do?curpage=${data.curPage+1 }&loginId=${log}&userName=${un}">下一页</a>&nbsp;&nbsp;
				<a href="../equipmentType/equipmentTypeList.do?curpage=${data.totalPage }">尾 页</a>&nbsp;&nbsp;
			</c:if>
			第&nbsp;<input id="pagebox" type="text" size="4">&nbsp;页&nbsp;
			<a onclick="jump('../equipmentType/equipmentTypeList.do?curpage=','${data.totalPage }');" href="javascript:;">跳转</a>
		</p>
	</div>
</body>
</html>
