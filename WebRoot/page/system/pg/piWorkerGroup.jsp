<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>

<title>巡检组列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jump.js"></script>
</head>

<body>
<div class="containner">
	<div id="inner-hd">
    	<div class="crumbs">
            <a href="javascript:;" class="crumbs-label">系统管理&gt;&gt;巡检组列表</a>
        </div>
    </div>
    <div id="inner-bd">
        <div class="button-group">
            <div class="button">
            <a href="../pigroup/toAdd">
              <img src="${pageContext.request.contextPath}/images/add.gif">
            </a>
            </div>
         </div>
         <table class="kv-table">
         	<thead>
            	 <tr>
                    <td class="kv-num">巡检组编号 </td>
                    <td class="kv-name">巡检组名称 </td>
                    <td class="kv-handle">操作</td>
                </tr>

            </thead>
            <tbody>
			
			<c:forEach items="${data.pageData}" var="group">
				<tr>
                    <td class="kv-num">${group.id }</td>
                    <td class="kv-name">${group.name }</td>
                    <td class="kv-handle">
					  <div class="handle">
					        <span class="handle-icon fix"></span>
                        	<span class="handle-icon editstate"></span>
							
                       </div>
					</td>
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
			<a href="../pigroup/pigrouplist?curpage=${data.curPage-1 }">上一页</a>
			<a href="../pigroup/pigrouplist?curpage=1 ">首 页</a>
		</c:if>
		<c:if test="${data.curPage!=data.totalPage }">
			<a href="../pigroup/pigrouplist?curpage=${data.curPage+1 }&loginId=${log}&userName=${un}">下一页</a>
			<a href="../pigroup/pigrouplist?curpage=${data.totalPage }">尾 页</a>
		</c:if>
		第<input id="pagebox" type="text" size="4">页
		<a onclick="jump('../pigroup/pigrouplist?curpage=','${data.totalPage }');" href="javascript:;">跳转</a>
		   </p></div>
</body>
</html>
