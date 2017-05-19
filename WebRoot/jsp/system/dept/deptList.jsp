<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML >
<html>
<head>

<title>部门列表</title>
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
				<a href="javascript:;" class="crumbs-label">系统管理>>部门列表</a>
			</div>
		</div>
		<div id="inner-bd">
			<div class="button-group">
				<div class="button">
					<img src="${pageContext.request.contextPath}/images/add.gif"
						onclick="location.href='../dept/toAdd.do'">
				</div>
				<div class="button">
					<img src="${pageContext.request.contextPath}/images/search1.gif"
						onclick="openfind();">
				</div>
			</div>
			<div id="find" ${hiddenFind }>
				<form action="../dept/deptList.do" method="post">
					<table>
						<tr>
							<td>部门名：</td>
							<td><input name="searchDeptName" type="text" value=""></td>
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
						<td class="kv-num">部门编号</td>
						<td class="kv-name">部门名称</td>
						<td class="kv-handle">操作</td>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${data.pageData}" var="dept">
						<tr>
							<td>${dept.id }</td>
							<td>${dept.name }</td>
							<td>
								<div class="handle">
									<span class="handle-icon del" onclick="delDepart(${dept.id })"></span>
									<a href="../dept/dept2Update.do?deptId=${dept.id}"><span
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
				<a href="../dept/deptList.do?curpage=${data.curPage-1 }">上一页</a>
				<a href="../dept/deptList.do?curpage=1 ">首 页</a>
			</c:if>
			<c:if test="${data.curPage!=data.totalPage }">
				<a
					href="../dept/deptList.do?curpage=${data.curPage+1 }&loginId=${log}&userName=${un}">下一页</a>
				<a href="../dept/deptList.do?curpage=${data.totalPage }">尾 页</a>
			</c:if>
			第<input id="pagebox" type="text" size="4">页 <a
				onclick="jump('../dept/deptList.do?curpage=','${data.totalPage }');"
				href="javascript:;">跳转</a>
		</p>
	</div>
</body>
<script>
	function delDepart(id){
		if(confirm("确定要删除吗？")){
			window.location.href="${pageContext.request.contextPath}/dept/deptDelete.do?deptId="+id;
		}
	}
</script>
</html>
