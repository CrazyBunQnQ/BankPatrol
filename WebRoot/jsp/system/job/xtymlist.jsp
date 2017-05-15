<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML >
<html>
<head>

<title>展现可操作页面信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/base.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jump.js"></script>
</head>
<body>
	<div class="containner">
		<div id="inner-hd">
			<div class="crumbs">
				<td width="98%"><span class="crumbs-label">系统管理&gt;&gt;岗位管理&gt;&gt;岗位页面展现</span></td>
			</div>
		</div>
		<div id="inner-bd">
			<table class="kv-table">
				<thead>
					<tr>
						<td>页面编号</td>
						<td>可操作页面</td>
						<td>可操作模块</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${data.pageData }" var="gw">
						<tr>
							<td>${gw.xtymb.id }</td>
							<td>${gw.xtymb.name }</td>
							<td>${gw.xtymb.function.name }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<p align="right">
				<font color="black">共&nbsp;</font><font color="black">${data.totalRecord}</font><font color="black">&nbsp;项&nbsp;&nbsp;</font>
				<font color="black">每页&nbsp;</font><font color="black">${data.pageSize }</font><font color="black">&nbsp;项&nbsp;&nbsp;</font>
				<font color="black">当前第&nbsp;</font><font color="black">${data.curPage }</font><font color="black">&nbsp;页&nbsp;&nbsp;</font>
				<font color="black">共&nbsp;</font><font color="black">${data.totalPage }</font><font color="black">&nbsp;页&nbsp;&nbsp;</font>
		
				<c:if test="${data.curPage!=1 }">
					<a href="../job/xtymList.do?jobId=${jobId }&curpage=${data.curPage-1 }">上一页</a>&nbsp;&nbsp;
					<a href="../job/xtymList.do?jobId=${jobId }&curpage=1 ">首 页</a>&nbsp;&nbsp;
				</c:if>
				<c:if test="${data.curPage!=data.totalPage }">
					<a href="../job/xtymList.do?jobId=${jobId }&curpage=${data.curPage+1 }">下一页</a>&nbsp;&nbsp;
					<a href="../job/xtymList.do?jobId=${jobId }&curpage=${data.totalPage }">尾 页</a>&nbsp;&nbsp;
				</c:if>
				第&nbsp;<input id="pagebox" type="text" size="4">&nbsp;页&nbsp;
				<a onclick="jump('../job/xtymList.do?jobId=${jobId }&curpage=','${data.totalPage }');" href="javascript:;">跳转</a>
			</p>
			
			<div align="center">
				<input type="button" value="返回" onclick="history.back();">
			</div>
		</div>
</body>
</html>
