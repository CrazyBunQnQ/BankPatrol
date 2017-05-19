<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE HTML>
<html>
<head>
    <title>日志列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jump.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
</head>
<body>
 <div class="containner">
	<div id="inner-hd">
    	<div class="crumbs">
            <a href="javascript:;" class="crumbs-label">系统管理&gt;&gt;巡检工基本信息列表</a>
        </div>
    </div>
    <div id="inner-bd">
			<div class="button-group">
				<div class="button">
					<input name="button" type="image" src="${pageContext.request.contextPath }/images/add.gif" onclick="location.href='../piwoker/toAdd.do'" />
				</div>
				<div class="button">
					<input name="button" type="image" src="${pageContext.request.contextPath }/images/search1.gif" onclick="openfind();" />
				</div>
			</div>
			<div id="find"  ${hiddenFind }>
				<form action="../piwoker/piwokerList.do" method="post">
					<table>
						<tr>
							<td>巡检工姓名： </td>
							<td><input name="searchPiWokerName" type="text" value=""></td>
							<td>
								<input type="image" src="${pageContext.request.contextPath }/images/search1.gif" class="input_button9" title="搜索"/>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
    <div id="inner-bd">
   
         <table class="kv-table">
         	<thead>
            		<tr>
						<td >巡检工编号 </td>
						<td >巡检工姓名  </td>
						<td >电话1</td>
						<td >电话2</td>
						<td >操作</td>
					</tr>
            		
            </thead>
            
            <tbody>
         
					<c:forEach items="${data.pageData}" var="piWorker">
					<tr>
						<td >${piWorker.id}</td>
						<td >${piWorker.workerName}</td>
						<td >${piWorker.tel1}</td>
						<td >${piWorker.tel2}</td>
						<td ><div class="handle">
                        	<a href="../piwoker/deletePiworker.do?id=${piWorker.id}"><span class="handle-icon del"></span></a>
                            <a href="../piwoker/update2Piworker.do?id=${piWorker.id}"><span class="handle-icon fix"></span></a>
                        </div></td>
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
		<font color="black">${data.totalPage }</font> <font color="black">页&nbsp;
		</font>

		<c:if test="${data.curPage!=1 }">
			<a href="../piwoker/piwokerList.do?curpage=${data.curPage-1 }">上一页</a>
			<a href="../piwoker/piwokerList.do?curpage=1 ">首 页</a>
		</c:if>
		<c:if test="${data.curPage!=data.totalPage }">
			<a href="../piwoker/piwokerList.do?curpage=${data.curPage+1 }&loginId=${log}&userName=${un}">下一页</a>
			<a href="../piwoker/piwokerList.do?curpage=${data.totalPage }">尾 页</a>
		</c:if>
		第<input id="pagebox" type="text" size="4">页
		<a onclick="jump('../piwoker/piwokerList.do?curpage=','${data.totalPage }');" href="javascript:;">跳转</a>
		   </p></div>
</body>
</html>
