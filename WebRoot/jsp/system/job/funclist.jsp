<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML >
<html>
<head>

<title>程序功能展现</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/base.css">
</head>
<body>
	<div class="containner">
		<div id="inner-hd">
			<div class="crumbs">
				<span class="crumbs-label">系统管理&gt;&gt;岗位管理&gt;&gt;程序功能列表</span>
			</div>
		</div>
		<div id="inner-bd">
			<table class="kv-table">
				<thead>
					<tr>
						<td>编号</td>
						<td>名称</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${data }" var="func">
						<tr>
							<td>${func.id }</td>
							<td>${func.name }</td>
							<td>
								<div class="handle">
									<a href="../job/showXtyms.do?jobId=${jobId }&funcId=${func.id }"><span class="handle-icon chakan"></span></a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<center>
				<input type="button" value="返回" onclick="window.location.href='${pageContext.request.contextPath }/job/jobList.do'">
			</center>
		</div>
	</div>
</body>
</html>
