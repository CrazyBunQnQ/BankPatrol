<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML >
<html>
<head>
<title>用户分页展现</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jump.js"></script>

</head>

<body>
	<div class="containner">
		<div id="inner-hd">
			<div class="crumbs">
				<span class="crumbs-label">
					<a href="${pageContext.request.contextPath }/center.jsp">系统管理</a>&gt;&gt;
					<a href="${pageContext.request.contextPath }/user/userlist">用户管理</a>
			</div>
		</div>
		
		<div id="inner-bd">
			<div class="button-group">
				<div class="button">
					<input name="button" type="image" src="${pageContext.request.contextPath }/images/add.gif" onclick="location.href='../user/toAdd'" />
				</div>
				<div class="button">
					<input name="button" type="image" src="${pageContext.request.contextPath }/images/search1.gif" onclick="openfind();" />
				</div>
			</div>
			
			<div id="find" ${hiddenFind }>
				<form action="../user/userlist">
					<table>
						<tr>
							<td>用户登陆ID：</td>
							<td><input name="loginId" type="text" value="${loginId }"></td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户中文名：</td>
							<td><input name="userName" type="text" value="${userName }">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td>
								<input type="image" src="${pageContext.request.contextPath }/images/search1.gif" class="input_button9" title="搜索"></input>
								<input id="hiddenFind" name="hiddenFind" type="text" value="hidden" hidden="true">
							</td>
						</tr>
					</table>
				</form>
			</div>
		
			<table class="kv-table">
				<thead>
					<tr>
						<td>用户登陆ID</td>
						<td>用户中文名字</td>
						<td>用户所在部门</td>
						<td>用户所属岗位</td>
						<td>用户状态</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${data.pageData}" var="user">
						<tr>
							<td>${user.loginId }</td>
							<td>${user.name }</td>
							<td>${user.departmentName }</td>
							<td>${user.jobName }</td>
							<td>${user.status?'启用':'禁用' }</td>
							<td>
								<div class="handle">
									<a href="../user/toUserUpte?loginId=${user.loginId }"><span class="handle-icon fix"></span></a>
									<c:if test="${user.loginId!='admin' }">
										<a href="../user/userDelete?userId=${user.loginId }"><span class="handle-icon del"></span></a>
									</c:if>
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
					<a href="../user/userlist?loginId=${loginId }&userName=${userName }&hiddenFind=${hiddenFind }&curpage=${data.curPage-1 }">上一页</a>&nbsp;&nbsp;
					<a href="../user/userlist?loginId=${loginId }&userName=${userName }&hiddenFind=${hiddenFind }&curpage=1 ">首 页</a>&nbsp;&nbsp;
				</c:if>
				<c:if test="${data.curPage!=data.totalPage }">
					<a href="../user/userlist?loginId=${loginId }&userName=${userName }&hiddenFind=${hiddenFind }&curpage=${data.curPage+1 }">下一页</a>&nbsp;&nbsp;
					<a href="../user/userlist?loginId=${loginId }&userName=${userName }&hiddenFind=${hiddenFind }&curpage=${data.totalPage }">尾 页</a>&nbsp;&nbsp;
				</c:if>
				第&nbsp;<input id="pagebox" type="text" size="4">&nbsp;页&nbsp;
				<a onclick="jump('../user/userlist?loginId=${loginId }&userName=${userName }&hiddenFind=${hiddenFind }&curpage=','${data.totalPage }');" href="javascript:;">跳转</a>
			</p>
		</div>
	</div>
</body>
</html>