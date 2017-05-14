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
<link rel="stylesheet" type="text/css" href="../css/main.css">
<script type="text/javascript" src="../js/check.js"></script>
</head>

<body>
	<span class="sys_list_yh">系统管理&gt;&gt;岗位管理&gt;&gt;修改岗位信息</span>
	<form action="" method="post" onsubmit="return checkData();">
		<table width="60%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#E4E4E4">
			<tr bgcolor="#F2F2F2">
				<td><input name="jobId" value="" type="hidden"></td>
			</tr>
			<td align="center">岗位名称：</td>
			<td><input name="jobName" value="董事长" id="jobName" onblur="checkJobName(this.value);"><span align="left" id="div1"></span></td>
			</tr>
			<tr bgcolor="#F2F2F2">
				<td align="center">岗位描述：</td>
				<td><textarea name="description" cols="30" rows="3">最高统治者</textarea></td>
			</tr>
		</table>
		<br>
		<center>
			<input type="submit" value="修改">&nbsp;&nbsp;<input type="button" value="返回" onclick="history.back();">
		</center>
	</form>
</body>
</html>
