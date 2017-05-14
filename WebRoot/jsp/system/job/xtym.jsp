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

<link rel="stylesheet" type="text/css" href="../css/main.css">
<script type="text/javascript" src="../js/check.js">
  </script>
<style>
#bodyStyle {
	overflow: auto;
}
</style>
</head>

<body id="bodeStyle">
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">

		<tr>
			<td width="2%" align="center"></td>
			<td width="98%"><span class="sys_list_yh">系统管理&gt;&gt;岗位管理</span></td>
		</tr>
	</table>
	<br />
	<center>
		<span class="sys_list_yh">页面列表</span>
	</center>
	<form action="" method="post">
		<table width="50%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#E4E4E4">
			<div align="top" valign="left">
				<input type="checkbox" name="allbox" onclick="checkall();"> 全选/撤选
			</div>
			<tr bgcolor="#F2F2F2">
				<td bgcolor="#F2F2F2" align="center" width="15%">选择</td>
				<td bgcolor="#F2F2F2" align="center" width="15%">页面名称</td>
			</tr>

			<tr bgcolor="#F2F2F2">


				<td><input type="checkbox" value="7" checked name="ymbhs"></td>
				<td>网点查看报修信息</td>



			</tr>

			<tr bgcolor="#F2F2F2">


				<td><input type="checkbox" value="8" checked name="ymbhs"></td>
				<td>巡检中心查看报修信息</td>



			</tr>

			<tr bgcolor="#F2F2F2">


				<td><input type="checkbox" value="13" checked name="ymbhs"></td>
				<td>网点设备报修</td>



			</tr>

			<tr bgcolor="#F2F2F2">


				<td><input type="checkbox" value="14" checked name="ymbhs"></td>
				<td>值班员报修</td>



			</tr>

			<tr bgcolor="#F2F2F2">


				<td><input type="checkbox" value="16" checked name="ymbhs"></td>
				<td>网点对报修确认</td>



			</tr>

			<tr bgcolor="#F2F2F2">


				<td><input type="checkbox" value="17" checked name="ymbhs"></td>
				<td>巡检中心分配小组</td>



			</tr>

			<tr bgcolor="#F2F2F2">


				<td><input type="checkbox" value="18" checked name="ymbhs"></td>
				<td>维修工确认维修</td>



			</tr>

		</table>
		<br>
		<center>
			<input type="submit" value="新增"> &nbsp;&nbsp; <input type="button" value="返回" onclick="history.back();">
		</center>
	</form>
</body>
</html>
