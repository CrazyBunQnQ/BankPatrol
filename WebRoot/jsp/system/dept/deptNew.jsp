<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML >
<html>
  <head>
    <title>新增部门</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/check.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css">
  </head>
  
  <body>
  <div id="inner-hd">
    	<div class="crumbs">
            <a href="javascript:;" class="crumbs-label">系统管理&gt;&gt;部门列表&gt;&gt;新增部门</a>
        </div>
    </div>
  
     <form action="${pageContext.request.contextPath }/dept/deptAdd.do" method="post" onsubmit="return checkDeptname('deptname')">
        <table align="center" border="1" width="60%">
           <tr>
             <td bgcolor="#F2F2F2" align="center" width="30%">部门名称</td><td><input type="text" name="departmentName" id="deptname" onblur="checkDeptname('deptname')">
             <span id="show"></span>
             </td>
           </tr> 
           
        </table>
        <p align="center" style="width: 400px; margin-top: 20px;">
          <input type="submit" value="保存"> 
          <input type="button" value="返回" onclick="history.back();">
        </p>
     </form>
  </body>
</html>
