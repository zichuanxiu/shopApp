<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 引入c标签 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 给项目取别名 -->
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!-- 引入公共页面的js|css样式 -->
<link rel=stylesheet type="text/css" href="${ctx}/css/main.css"/>

<link type="text/css" href="${ctx}/css/ui-lightness/jquery-ui-1.8.20.custom.css" rel="stylesheet" />

<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="js/jquery-ui.js"></script>
	<!-- <script type="text/javascript" src="js/pager.js"></script> -->
	<!-- header.js输出头部信息 -->
<script type="text/javascript" src="js/header.js"></script>	