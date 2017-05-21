<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML >
<html>
<head>
<title>修改岗位信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/base.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/check.js"></script>
</head>

<body>
	<div class="containner">
		<div id="inner-hd">
			<div class="crumbs">
				<span class="crumbs-label">
					<a href="${pageContext.request.contextPath }/center.jsp">系统管理</a>&gt;&gt;
					<a href="${pageContext.request.contextPath }/job/jobList">岗位管理</a>&gt;&gt;
					修改岗位信息
				</span>
			</div>
		</div>
		<div id="inner-bd">
			<form action="${pageContext.request.contextPath }/job/updateJob?id=${job.id }" method="post" onsubmit="return checkData();">
				<table class="kv-table">
					<tr bgcolor="#F2F2F2">
						<td colspan="2"><input name="jobId" value="${job.id }" type="hidden"></td>
					</tr>
					<tr>
						<td align="center">岗位名称：</td>
						<td align="left" style="padding-left: 100px">
							<input name="jobName" value="${job.name }" id="jobName" onblur="checkJobName(this.value);">
							<span align="left" id="div1"></span>
						</td>
					</tr>
					<tr bgcolor="#F2F2F2">
						<td align="center">岗位描述：</td>
						<td align="left" style="padding-left: 100px"><textarea name="description" cols="30" rows="3">${job.description }</textarea></td>
					</tr>
				</table>
				<br>
				<center>
					<input type="submit" value="修改">&nbsp;&nbsp;<input type="button" value="返回" onclick="history.back();">
				</center>
			</form>
		</div>
	</div>
</body>
</html>
