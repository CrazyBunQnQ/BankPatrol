<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML >
<html>
<head>
<title>银行网点列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<link href="${pageContext.request.contextPath }/css/base.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div class="containner">
		<div id="inner-hd">
			<div class="crumbs">
				<a href="javascript:;" class="crumbs-label">系统管理&gt;&gt;银行网点列表</a>
			</div>
		</div>
		<div id="inner-bd">
			<div class="button-group">
				<div class="button">
					<img src="${pageContext.request.contextPath }/images/add.gif" onclick="location.href='../bank/toAdd.do'">
				</div>
			</div>
			<table class="kv-table">
				<thead>
					<tr>
						<td>银行ID</td>
						<td>银行名称</td>
						<td>银行位置经度</td>
						<td>银行位置纬度</td>
						<td>银行IP</td>
						<td>操作</td>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${data.pageData }" var="bank">
						<tr>
							<td>${bank.id }</td>
							<td>${bank.name }</td>
							<td>${bank.longitude }</td>
							<td>${bank.latitude }</td>
							<td>${bank.ip }</td>
							<td>
								<div class="handle">
									<a href="../bank/toUpdate.do?bankId=${bank.id }"><span class="handle-icon fix"></span></a>
									<a href="../bank/delete.do?bankId=${bank.id }"><span class="handle-icon del"></span></a>
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
			<font color="black">项&nbsp;</font> <font color="black">每页</font>
			<font color="black">${data.pageSize }</font><font color="black">项&nbsp;</font>
			<font color="black">当前第</font><font color="black">${data.curPage }</font>
			<font color="black">页&nbsp;</font> <font color="black">共</font>
			<font color="black">${data.totalPage }</font> <font color="black">页&nbsp;
			</font>
	
			<c:if test="${data.curPage!=1 }">
				<a href="../user/userList.do?curpage=${data.curPage-1 }">上一页</a>
				<a href="../user/userList.do?curpage=1 ">首 页</a>
			</c:if>
			<c:if test="${data.curPage!=data.totalPage }">
				<a href="../user/userList.do?curpage=${data.curPage+1 }&loginId=${log}&userName=${un}">下一页</a>
				<a href="../user/userList.do?curpage=${data.totalPage }">尾 页</a>
			</c:if>
			第<input id="pagebox" type="text" size="4">页
			<a onclick="goPage('../user/userList.do?curpage=');" href="javascript:;">跳转</a>
		</p>
	</div>
</body>
</html>
