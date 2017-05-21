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
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>
<link href="${pageContext.request.contextPath }/nifty/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/nifty/css/nifty.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/nifty/css/demo/nifty-demo-icons.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/nifty/css/demo/nifty-demo.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/nifty/plugins/datatables/media/css/dataTables.bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/nifty/plugins/datatables/extensions/Responsive/css/dataTables.responsive.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/nifty/plugins/pace/pace.min.css" rel="stylesheet">

<script src="${pageContext.request.contextPath }/nifty/plugins/pace/pace.min.js"></script>
<script src="${pageContext.request.contextPath }/nifty/js/jquery-2.2.4.min.js"></script>
<script src="${pageContext.request.contextPath }/nifty/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/nifty/js/nifty.min.js"></script>
<script src="${pageContext.request.contextPath }/nifty/js/demo/nifty-demo.min.js"></script>
<script src="${pageContext.request.contextPath }/nifty/plugins/datatables/media/js/jquery.dataTables.js"></script>
<script src="${pageContext.request.contextPath }/nifty/plugins/datatables/media/js/dataTables.bootstrap.js"></script>
<script src="${pageContext.request.contextPath }/nifty/plugins/datatables/extensions/Responsive/js/dataTables.responsive.min.js"></script>
<script src="${pageContext.request.contextPath }/nifty/js/demo/tables-datatables.js"></script>
</head>

<body>
	<div class="panel">
		<div class="panel-heading">
			<h3 class="panel-title">用户管理</h3>
		</div>
		<div id="demo-custom-toolbar" class="table-toolbar-left">
			<button id="demo-dt-delete-btn" class="btn btn-danger">
				<i class="demo-pli-cross"></i> 删除
			</button>
			<button id="demo-dt-addrow-btn" class="btn btn-primary">
				<i class="demo-pli-add-user"></i> 添加
			</button>
		</div>
		<div class="panel-body">
			<table id="demo-dt-delete" class="table table-striped table-bordered" cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>登录 ID</th>
						<th>姓名</th>
						<!-- th class="min-tablet">所在部门</th>
						<th class="min-tablet">岗位</th>
						<th class="min-desktop">状态</th>
						<th class="min-desktop">操作</th -->
						<th>所在部门</th>
						<th>岗位</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="user">
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
		</div>
	</div>
</body>
</html>