<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<title>登录页面</title>
<!--  link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/font-awesome.min.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/login.js"></script -->
<!--Open Sans Font [ OPTIONAL ]-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>

    <!--Bootstrap Stylesheet [ REQUIRED ]-->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!--Nifty Stylesheet [ REQUIRED ]-->
    <link href="css/nifty.min.css" rel="stylesheet">

    <!--Nifty Premium Icon [ DEMONSTRATION ]-->
    <link href="css/demo/nifty-demo-icons.min.css" rel="stylesheet">

    <!--Demo [ DEMONSTRATION ]-->
    <link href="css/demo/nifty-demo.min.css" rel="stylesheet">
        
    <!--Magic Checkbox [ OPTIONAL ]-->
    <link href="plugins/magic-check/css/magic-check.min.css" rel="stylesheet">

    <!--JAVASCRIPT-->
    <!--=================================================-->

    <!--Pace - Page Load Progress Par [OPTIONAL]-->
    <link href="plugins/pace/pace.min.css" rel="stylesheet">
    <script src="plugins/pace/pace.min.js"></script>

    <!--jQuery [ REQUIRED ]-->
    <script src="js/jquery-2.2.4.min.js"></script>

    <!--BootstrapJS [ RECOMMENDED ]-->
    <script src="js/bootstrap.min.js"></script>

    <!--NiftyJS [ RECOMMENDED ]-->
    <script src="js/nifty.min.js"></script>

    <!--=================================================-->
    
    <!--Demo script [ DEMONSTRATION ]-->
    <script src="js/demo/nifty-demo.min.js"></script>
</head>

<body>
<div class="container">
    <div class="box">
        <div class="title"></div>
      <form name="form1" method="post" action="${pageContext.request.contextPath }/login/login.do" onsubmit="return checkdata();" class="loginbox">
            <span class="heading">用户登录</span>
            <div class="form-group">
                <input name="loginId" type="text" class="form-control" placeholder="用户名" />
                <i class="fa fa-user"></i>
            </div>
            <div class="form-group">
                <input  name="loginPassword" type="password" class="form-control" id="inputPassword3" placeholder="密　码">
                <i class="fa fa-lock"></i>
            </div>
            <div class="form-group">
                <button type="submit" class="btn">登录</button>
            </div>
        </form>
        <div class="gold"></div>
    </div>
</div>
	<div class="col-sm-6">
		<div class="panel">
			<div class="panel-heading">
				<h3 class="panel-title">Horizontal form</h3>
			</div>

			<!--Horizontal Form-->
			<!--===================================================-->
			<form class="form-horizontal">
				<div class="panel-body">
					<div class="form-group">
						<label class="col-sm-3 control-label" for="demo-hor-inputemail">Email</label>
						<div class="col-sm-9">
							<input type="email" placeholder="Email" id="demo-hor-inputemail"
								class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" for="demo-hor-inputpass">Password</label>
						<div class="col-sm-9">
							<input type="password" placeholder="Password"
								id="demo-hor-inputpass" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-9">
							<input id="demo-remember-me-2" class="magic-checkbox"
								type="checkbox"> <label for="demo-remember-me-2">Remember
								me</label>
						</div>
					</div>
				</div>
				<div class="panel-footer text-right">
					<button class="btn btn-success" type="submit">Sign in</button>
				</div>
			</form>
			<!--===================================================-->
			<!--End Horizontal Form-->

		</div>
	</div>
</body>
</html>