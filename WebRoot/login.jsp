<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<title>登录页面</title>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>
<link href="${pageContext.request.contextPath }/nifty/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/nifty/css/nifty.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/nifty/css/demo/nifty-demo-icons.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/nifty/css/demo/nifty-demo.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/nifty/plugins/magic-check/css/magic-check.min.css" rel="stylesheet">
<!--JAVASCRIPT-->
<link href="${pageContext.request.contextPath }/nifty/plugins/pace/pace.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath }/nifty/plugins/pace/pace.min.js"></script>
<script src="${pageContext.request.contextPath }/nifty/js/jquery-2.2.4.min.js"></script>
<script src="${pageContext.request.contextPath }/nifty/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/nifty/js/nifty.min.js"></script>

<script src="${pageContext.request.contextPath }/nifty/js/demo/nifty-demo.min.js"></script>
</head>

<body>
				<div class="col-sm-6" style="height: 30px">
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">用户登录</h3>
						</div>

						<!--Horizontal Form-->
						<!--===================================================-->
						<form class="form-horizontal" action="${pageContext.request.contextPath }/user/login" method="post">
							<div class="panel-body">
								<div class="form-group">
									<label class="col-sm-3 control-label" for="demo-hor-inputemail">用户名</label>
									<div class="col-sm-9">
										<input type="text" name="user.loginId" placeholder="Login Id" id="demo-hor-inputemail" class="form-control">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label" for="demo-hor-inputpass">密码</label>
									<div class="col-sm-9">
										<input type="password" name="user.loginPwd" placeholder="Password" id="demo-hor-inputpass" class="form-control">
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-3 col-sm-9">
										<input id="demo-remember-me-2" class="magic-checkbox" type="checkbox"> <label for="demo-remember-me-2">记住我</label>
									</div>
								</div>
							</div>
							<div class="panel-footer text-right">
								<button class="btn btn-success" type="submit">登录</button>
							</div>
						</form>
						<!--===================================================-->
						<!--End Horizontal Form-->

					</div>
				</div>
</body>
</html>