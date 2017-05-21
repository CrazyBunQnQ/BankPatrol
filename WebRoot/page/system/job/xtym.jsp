<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML >
<html>
<head>

<title>页面列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/base.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/check.js">
	
</script>
<style>
#bodyStyle {
	overflow: auto;
}
</style>
</head>

<body id="bodeStyle">
	<div class="containner">
		<div id="inner-hd">
			<div class="crumbs">
				<span class="crumbs-label">
					<a href="${pageContext.request.contextPath }/center.jsp">系统管理</a>&gt;&gt;
					<a href="${pageContext.request.contextPath }/job/jobList">岗位管理</a>&gt;&gt;
					系统管理页面列表
				</span>
			</div>
		</div>
		<div id="inner-bd">
			<!-- center>
				<span class="sys_list_yh">页面列表</span>
			</center -->
			<form action="${pageContext.request.contextPath }/job/updateXtym?jobId=${jobId }&funcId=${funcId }" method="post">
				<table  class="kv-table">
					<thead>
						<tr>
							<td><input type="checkbox" name="allbox" onclick="checkall();"> 全选/撤选</td>
							<td>页面名称</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${gws }" var="gw">
							<tr>
								<td><input type="checkbox" value="${gw.xtymb.id }" ${gw.getOpenStr() } name="ymbhs"></td>
								<td><font>${gw.xtymb.name }</font></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br>
				<center>
					<input type="submit" value="更新"> &nbsp;&nbsp; <input type="button" value="返回" onclick="history.back();">
				</center>
			</form>
		</div>
	</div>
</body>
</html>
