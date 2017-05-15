<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML >
<html>
  <head>
    
    <title>修改部门</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/base.css">

  </head>
  
  <body>
  <div id="inner-hd">
    	<div class="crumbs">
            <a href="javascript:;" class="crumbs-label">系统管理&gt;&gt;部门列表&gt;&gt;修改部门</a>
        </div>
    </div>
  <table>
    <form action="${pageContext.request.contextPath}/dept/deptUpdate.do" method="post">
        <table align="center" border="1" width="60%">
          <tr>
          	<td bgcolor="#F2F2F2" align="center" width="30%">部门编号</td><td>  <input name="department_id" readonly value="${dept.id }"></td>
          </tr>
          <tr>
             <td bgcolor="#F2F2F2" align="center" width="30%">部门名称</td>
             <td>
             <input name="departmentName" value="${dept.name }">
             </td>
          </tr>
        </table>
        <p align="center" style="width: 400px; margin-top: 20px;">
           <input type="submit" value="修改">
           <input type="button" value="返回" onclick="history.back();">
        </p>
     </form>
     </table>
  </body>
</html>
