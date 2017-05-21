<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML >
<html>
<head>

<title>岗位列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/base.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jump.js"></script>
</head>

<body>
	<div class="containner">
		<div id="inner-hd">
			<div class="crumbs">
				<span class="crumbs-label">
					<a href="${pageContext.request.contextPath }/center.jsp">系统管理</a>&gt;&gt;
					<a href="${pageContext.request.contextPath }/job/jobList">岗位管理&gt;&gt;岗位列表</a>
				</span>
			</div>
		</div>
		<div id="inner-bd">
			<div class="button-group">
				<div class="button">
					<img src="${pageContext.request.contextPath }/images/add.gif" onclick="location.href='../job/toAdd'">
				</div>
			</div>
			
			<table class="kv-table">
				<thead>
					<tr>
						<td>编号</td>
						<td>名称</td>
						<td>描述</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${data.pageData }" var="job">
						<tr>
							<td>${job.id }</td>
							<td>
								<a href="../job/xtymList?jobId=${job.id }">${job.name }</a>
							</td>
							<td>${job.description }</td>
							<td>
								<div class="handle">
									<a href="../job/toUpdate?jobId=${job.id }&jobName=${job.name }&description=${job.description }"><span class="handle-icon fix"></span></a>
									<a href="../job/funcList?jobId=${job.id }"><span class="handle-icon chakan"></span></a>
								</div>
							</td>
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
					<a href="../job/jobList?curpage=${data.curPage-1 }">上一页</a>&nbsp;&nbsp;
					<a href="../job/jobList?curpage=1 ">首 页</a>&nbsp;&nbsp;
				</c:if>
				<c:if test="${data.curPage!=data.totalPage }">
					<a href="../job/jobList?curpage=${data.curPage+1 }">下一页</a>&nbsp;&nbsp;
					<a href="../job/jobList?curpage=${data.totalPage }">尾 页</a>&nbsp;&nbsp;
				</c:if>
				第&nbsp;<input id="pagebox" type="text" size="4">&nbsp;页&nbsp;
				<a onclick="jump('../job/jobList?curpage=','${data.totalPage }');" href="javascript:;">跳转</a>
			</p>
		</div>
	</div>
</body>
</html>
