<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<title>日志列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jump.js"></script>

</head>
<body>
<div class="containner">
	<div id="inner-hd">
    	<div class="crumbs">
            <a href="javascript:;" class="crumbs-label">系统管理&gt;&gt;日志列表</a>
        </div>
    </div>
    <div id="inner-bd">
    	<div class="button-log">
			<div class="button">
				<input name="button" type="image" src="${pageContext.request.contextPath }/images/exp.png" onclick="location.href='../log/exportLogs.do'" />
			</div>
			<div class="button">
				<input name="button" type="image" src="${pageContext.request.contextPath }/images/clear.png" onclick="location.href='../log/clearLogs.do'" />
			</div>
		</div>
   
         <table class="kv-table">
         	<thead>
            		<tr>
						<td >日志编号</td>
						<td >登陆ID </td>
						<td >登陆时间</td>
						<td >退出时间</td>
					</tr>
            </thead>
            
            <tbody>
                <c:forEach items="${data.pageData}" var="Log">
					<tr>
						<td >${Log.id}</td>
						<td >${Log.useername}</td>
						<td >${Log.checkIn}</td>
						<td >${Log.checkOut}</td>
					</tr>
				</c:forEach>
            </tbody>
        </table>
	</div>
</div>
<div>
 <p align="right">
		<font color="black">共</font><font color="black">${data.totalRecord}</font>
		<font color="black">项&nbsp;</font> <font color="black">每页</font>
		<font color="black">${data.pageSize }</font><font color="black">项&nbsp;</font>
		<font color="black">当前第</font><font color="black">${data.curPage }</font>
		<font color="black">页&nbsp;</font> <font color="black">共</font>
		<font color="black">${data.totalPage }</font> <font color="black">页&nbsp; </font>
         
         <c:if test="${data.curPage!=1 }">
			<a href="../log/logList.do?curpage=${data.curPage-1 }">上一页</a>
			<a href="../log/logList.do?curpage=1 ">首 页</a>
		</c:if>
		<c:if test="${data.curPage!=data.totalPage }">
			<a href="../log/logList.do?curpage=${data.curPage+1 }&loginId=${log}&userName=${un}">下一页</a>
			<a href="../log/logList.do?curpage=${data.totalPage }">尾 页</a>
		</c:if>
		第<input id="pagebox" type="text" size="4">页
		<a onclick="jump('../log/logList.do?curpage=','${data.totalPage }');" href="javascript:;">跳转</a>
		   </p></div>
</body>
</html>