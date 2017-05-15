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

<link rel="stylesheet" type="text/css" href="../../css/main.css">
<script type="text/javascript" src="../../js/jump.js"></script>
<script type="text/javascript" src="../../js/jump.js"></script>
<script type="text/javascript">
    	function goto(u) {
		    var url = u;
		    var v = document.getElementById("pagebox").value;
		    var i=2 ;
		    if(v<1||v>i){
		    }else{
			location.href = url+v;
		  }
     }
    </script>
</head>
<body>

	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
				<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">

					<tr>
						<td width="2%" align="center"></td>
						<td width="98%"><span class="sys_list_yh">系统管理&gt;&gt;岗位管理&gt;&gt;岗位页面展现</span></td>
					</tr>
				</table> <br />
				<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="5%"></td>
						<td>
							<table width="95%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#E4E4E4">
								<tr>
									<td bgcolor="#F2F2F2" align="center" width="15%">页面编号</td>
									<td bgcolor="#F2F2F2" align="center" width="15%">可操作页面</td>
									<td bgcolor="#F2F2F2" align="center" width="15%">可操作模块</td>
								</tr>

								<tr align="center">
									<td bgcolor="#FFFFFF">1</td>
									<td bgcolor="#FFFFFF">用户管理</td>
									<td bgcolor="#FFFFFF">系统管理</td>
								</tr>

								<tr align="center">
									<td bgcolor="#FFFFFF">2</td>
									<td bgcolor="#FFFFFF">部门管理</td>
									<td bgcolor="#FFFFFF">系统管理</td>
								</tr>

								<tr align="center">
									<td bgcolor="#FFFFFF">3</td>
									<td bgcolor="#FFFFFF">日志管理</td>
									<td bgcolor="#FFFFFF">系统管理</td>
								</tr>

								<tr align="center">
									<td bgcolor="#FFFFFF">4</td>
									<td bgcolor="#FFFFFF">银行设备种类管理</td>
									<td bgcolor="#FFFFFF">系统管理</td>
								</tr>

								<tr align="center">
									<td bgcolor="#FFFFFF">5</td>
									<td bgcolor="#FFFFFF">全局变量管理</td>
									<td bgcolor="#FFFFFF">系统管理</td>
								</tr>

								<tr align="center">
									<td bgcolor="#FFFFFF">6</td>
									<td bgcolor="#FFFFFF">银行网点管理</td>
									<td bgcolor="#FFFFFF">系统管理</td>
								</tr>

								<tr align="center">
									<td bgcolor="#FFFFFF">9</td>
									<td bgcolor="#FFFFFF">岗位管理</td>
									<td bgcolor="#FFFFFF">系统管理</td>
								</tr>

								<tr align="center">
									<td bgcolor="#FFFFFF">10</td>
									<td bgcolor="#FFFFFF">巡检工管理</td>
									<td bgcolor="#FFFFFF">系统管理</td>
								</tr>

								<tr align="center">
									<td bgcolor="#FFFFFF">11</td>
									<td bgcolor="#FFFFFF">巡检组管理</td>
									<td bgcolor="#FFFFFF">系统管理</td>
								</tr>

								<tr align="center">
									<td bgcolor="#FFFFFF">12</td>
									<td bgcolor="#FFFFFF">设备问题报修管理</td>
									<td bgcolor="#FFFFFF">系统管理</td>
								</tr>

							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table width="95%" border="0" cellpadding="0" cellspacing="0" class="table0">
		<tr align="right">
			<td width="62%"><font color="black">共</font><font color="black">19</font> <font color="black">项&nbsp; <font color="black">每页</font><font color="black">10</font><font color="black">项&nbsp; <font color="black">当前第</font><font color="black">1</font> <font color="black">页&nbsp; <font color="black">共</font><font color="black">2</font> <font color="black">页&nbsp; <a href="/syyh/job/jobshow.do?curPage=2&jobId=1">下一页</a> <a href="/syyh/job/jobshow.do?curPage=2&jobId=1">尾页</a> &nbsp; <input id="pagebox" size="1" name="pagebox"></input>&nbsp; <a onclick="goto('/syyh/job/jobshow.do?jobId=1&curPage=');" href="javascript:;">跳转</a>&nbsp; <input id="totalPage" type="hidden" size="1"
								value="2" name="totalPage"></input></td>
		</tr>
	</table>
	<div align="center">
		<input type="button" value="返回" onclick="history.back();">
	</div>
</body>
</html>
