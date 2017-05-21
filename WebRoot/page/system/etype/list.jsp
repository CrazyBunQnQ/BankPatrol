<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML >
<html>
<head>

<title>银行设备种类管理展现</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/base.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jump.js"></script -->

<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>

    <!--Bootstrap Stylesheet [ REQUIRED ]-->
    <link href="${pageContext.request.contextPath }/nifty/css/bootstrap.min.css" rel="stylesheet">

    <!--Nifty Stylesheet [ REQUIRED ]-->
    <link href="${pageContext.request.contextPath }/nifty/css/nifty.min.css" rel="stylesheet">

    <!--Nifty Premium Icon [ DEMONSTRATION ]-->
    <link href="${pageContext.request.contextPath }/nifty/css/demo/nifty-demo-icons.min.css" rel="stylesheet">

    <!--Demo [ DEMONSTRATION ]-->
    <link href="${pageContext.request.contextPath }/nifty/css/demo/nifty-demo.min.css" rel="stylesheet">

    <!--DataTables [ OPTIONAL ]-->
    <link href="${pageContext.request.contextPath }/nifty/plugins/datatables/media/css/dataTables.bootstrap.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath }/nifty/plugins/datatables/extensions/Responsive/css/dataTables.responsive.css" rel="stylesheet">

    <!--JAVASCRIPT-->
    <!--=================================================-->

    <!--Pace - Page Load Progress Par [OPTIONAL]-->
    <link href="${pageContext.request.contextPath }/nifty/plugins/pace/pace.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/nifty/plugins/pace/pace.min.js"></script>


    <!--jQuery [ REQUIRED ]-->
    <script src="${pageContext.request.contextPath }/nifty/js/jquery-2.2.4.min.js"></script>


    <!--BootstrapJS [ RECOMMENDED ]-->
    <script src="${pageContext.request.contextPath }/nifty/js/bootstrap.min.js"></script>

    <!--NiftyJS [ RECOMMENDED ]-->
    <script src="${pageContext.request.contextPath }/nifty/js/nifty.min.js"></script>

    <!--=================================================-->
    
    <!--Demo script [ DEMONSTRATION ]-->
    <script src="${pageContext.request.contextPath }/nifty/js/demo/nifty-demo.min.js"></script>
    
    <!--DataTables [ OPTIONAL ]-->
    <script src="${pageContext.request.contextPath }/nifty/plugins/datatables/media/js/jquery.dataTables.js"></script>
	<script src="${pageContext.request.contextPath }/nifty/plugins/datatables/media/js/dataTables.bootstrap.js"></script>
	<script src="${pageContext.request.contextPath }/nifty/plugins/datatables/extensions/Responsive/js/dataTables.responsive.min.js"></script>

    <!--DataTables Sample [ SAMPLE ]-->
    <script src="${pageContext.request.contextPath }/nifty/js/demo/tables-datatables.js"></script>
    
</head>

<body>
	<div class="containner">
		<div id="inner-hd">
			<div class="crumbs">
				<a href="javascript:;" class="crumbs-label">系统管理&gt;&gt;银行设备种类管理列表</a>
			</div>
		</div>
		
		<div id="inner-bd">
			<div class="button-group">
				<div class="button">
					<img src="${pageContext.request.contextPath }/images/add.gif" onclick="location.href='../etype/toAdd.do'">
				</div>
				<div class="button">
					<img src="${pageContext.request.contextPath }/images/search1.gif" onclick="openfind();">
				</div>
			</div>
			
			<div id="find" ${hiddenFind }>
				<form action="${pageContext.request.contextPath }/etype/equipmentTypeList.do">
					<table>
						<tr>
							<td>设备种类 ID：</td>
							<td><input name="eType.id" type="text" value="${eType.id }"></td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;设备种类名称：</td>
							<td><input name="eType.name" type="text" value="${eType.name }">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td>
								<input type="image" src="${pageContext.request.contextPath }/images/search1.gif" class="input_button9" title="搜索"></input>
								<input id="hiddenFind" name="hiddenFind" type="text" value="hidden" hidden="true">
							</td>
						</tr>
					</table>
				</form>
			</div>
			
			<table class="kv-table">
				<thead>
					<tr>
						<td class="kv-num">设备种类ID</td>
						<td class="kv-name">设备种类名称</td>
						<td class="kv-handle">操作</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${data.pageData }" var="type">
						<tr>
							<td>${type.id }</td>
							<td>${type.name }</td>
							<td>
								<div class="handle">
									<a href="../etype/toUpdate.do?eTypeId=${type.id }&eTypeName=${type.name }"><span class="handle-icon fix"></span></a>
									<c:if test="${!type.hasEq }">
										<a href="../etype/deleteType.do?eTypeId=${type.id }"><span class="handle-icon del"></span></a>
									</c:if>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<p align="right">
				<font color="black">共&nbsp;</font><font color="black">${data.totalRecord}</font><font color="black">&nbsp;项&nbsp;&nbsp;</font>
				<font color="black">每页&nbsp;</font><font color="black">${data.pageSize }</font><font color="black">&nbsp;项&nbsp;&nbsp;</font>
				<font color="black">当前第&nbsp;</font><font color="black">${data.curPage }</font><font color="black">&nbsp;页&nbsp;&nbsp;</font>
				<font color="black">共&nbsp;</font><font color="black">${data.totalPage }</font><font color="black">&nbsp;页&nbsp;&nbsp;</font>
		
				<c:if test="${data.curPage!=1 }">
					<a href="../etype/equipmentTypeList.do?eTypeId=${eTypeId }&eTypeName=${eTypeName }&hiddenFind=${hiddenFind }&curpage=${data.curPage-1 }">上一页</a>&nbsp;&nbsp;
					<a href="../etype/equipmentTypeList.do?eTypeId=${eTypeId }&eTypeName=${eTypeName }&hiddenFind=${hiddenFind }&curpage=1 ">首 页</a>&nbsp;&nbsp;
				</c:if>
				<c:if test="${data.curPage!=data.totalPage }">
					<a href="../etype/equipmentTypeList.do?eTypeId=${eTypeId }&eTypeName=${eTypeName }&hiddenFind=${hiddenFind }&curpage=${data.curPage+1 }&loginId=${log}&userName=${un}">下一页</a>&nbsp;&nbsp;
					<a href="../etype/equipmentTypeList.do?eTypeId=${eTypeId }&eTypeName=${eTypeName }&hiddenFind=${hiddenFind }&curpage=${data.totalPage }">尾 页</a>&nbsp;&nbsp;
				</c:if>
				第&nbsp;<input id="pagebox" type="text" size="4">&nbsp;页&nbsp;
				<a onclick="jump('../etype/equipmentTypeList.do?eTypeId=${eTypeId }&eTypeName=${eTypeName }&hiddenFind=${hiddenFind }&curpage=','${data.totalPage }');" href="javascript:;">跳转</a>
			</p>
		</div>
	</div>
	<div class="panel">
		<div class="panel-heading">
			<h3 class="panel-title">Hover rows</h3>
		</div>

		<!--Hover Rows-->
		<!--===================================================-->
		<div class="panel-body">
			<table class="table table-hover table-vcenter">
				<thead>
					<tr>
						<th class="min-width">设备种类ID</th>
						<th>设备种类ID</th>
						<th class="text-center">Value</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="text-center"><i class="demo-pli-monitor-2 icon-2x"></i></td>
						<td><span class="text-main text-semibold">${eType.name }</span> <br>
							<small class="text-muted">Last 7 days : 4,234k</small></td>
						<td class="text-center"><span
							class="text-danger text-semibold">- 28.76%</span></td>
					</tr>
					<tr>
						<td class="text-center"><i class="demo-pli-laptop icon-2x"></i></td>
						<td><span class="text-main text-semibold">Laptop</span> <br>
							<small class="text-muted">Last 7 days : 3,876k</small></td>
						<td class="text-center"><span
							class="text-warning text-semibold">- 8.55%</span></td>
					</tr>
					<tr>
						<td class="text-center"><i class="demo-pli-tablet-2 icon-2x"></i></td>
						<td><span class="text-main text-semibold">Tablet</span> <br>
							<small class="text-muted">Last 7 days : 45,678k</small></td>
						<td class="text-center"><span
							class="text-success text-semibold">+ 58.56%</span></td>
					</tr>
					<tr>
						<td class="text-center"><i
							class="demo-pli-smartphone-3 icon-2x"></i></td>
						<td><span class="text-main text-semibold">Smartphone</span> <br>
							<small class="text-muted">Last 7 days : 34,553k</small></td>
						<td class="text-center"><span
							class="text-success text-semibold">+ 35.76%</span></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!--===================================================-->
		<!--End Hover Rows-->

	</div>
</body>
</html>
