<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<%@ taglib uri="http://org.deepthought.shopApp" prefix="dp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>购物商城-首页</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="fkjava.ico" rel="shortcut icon" type="image/x-icon" />
		<!-- main.css是购物商城主样式 -->
		
		<!-- 使用jQuery-UI的样式来设置tab页 -->
		
	
		<script type="text/javascript">
			if (window.location != parent.window.location){
				parent.window.location = window.location;
			}
			window.onload = function(){
				/** tabs标签页 */
				$('#tabs').tabs();
				
				//为选项改变绑定事件
				$("#typeCode1").change(function () {
					$("#form1").submit();
				})
				
				
				/** 设置选的下拉列表选项 */
				var typeCode="${typeCode1}";
				var select = document.getElementById("typeCode1");	
				var options=select.options;
				for (var i = 0; i < options.length; i++) {
					if (options[i].value==typeCode) {
						options[i].selected=true;
					}
				}
				
				
				/** 分页标签 */
				fkjava.pager("pager", { pageIndex : "1",
						pageSize : "8",
						pageCount : "32",
						submitUrl : '/fk_ec/index.action?pageIndex={0}&typecode=0001&keyword='});	
				
				/** 获取所有的li为特定的li绑定事件 */
				var arrays = document.getElementsByTagName("li");
				for (var i = 0; i < arrays.length; i++){
					if (arrays[i].id != "" && arrays[i].id.indexOf('selbgc1') == 0){
						arrays[i].onmouseover = function(){
							this.className = "selbgc1";
						};
						arrays[i].onmouseout = function(){
							this.className = "";
						};
					}
				}
				
			};
		</script>
	</head>
<body>
	<!-- header部分 -->
	<div id="shortcut">
		<script type="text/javascript">header("${user.name}");</script>
	﻿	<div class="nav">
			<div class="w960 center">
				<ul>
					<li><a title="首页" href="index.action">首页</a></li>
					<c:forEach items="${firstArticleTypeMap}" var="articleType">
						<li><a title="${articleType.name}" href="${ctx}/index.action?typecode=${articleType.code}">${articleType.name}</a></li>
					</c:forEach>
					
				</ul>
			</div>
		</div>
	</div>
	<!--header end-->
	<!-- middle part -->
	<div style="positon: relative; width: 960px;margin: 0px auto;">
		<!-- 左边物品类型列表 -->
		<div  id="booksort" style="float:left;width:210px;">
			<div class="mt" style="height:25px;font-size:14px;">
				<h2><strong>物品分类</strong></h2>
			</div>
			<div class="mc">
				<c:forEach items="${firstArticleTypeMap}" var="articleType">
						<div class="item"><h3><b>&gt;</b><a href="${ctx}/index.action?typecode=${articleType.code}">·${articleType.name}</a></h3></div>
					</c:forEach>
					
			</div>
		</div>
		<!-- 右边对应物品列表 -->
		<div style="float:left;width:750px;text-align:center;">
			<div>
				<form action="${ctx}/index.action" method="get" name="search id="form1" >
			  		物品类型：
			  		<select name="typeCode1" id="typeCode1">
				  		<option value="${firstCode}">${firstName}</option>
				  		<c:forEach items="${secondArticleType}" var="ArticleType">
				  			<option value="${ArticleType.code}">----${ArticleType.name}</option>
				  		</c:forEach>
				  			
				  		
			  		</select>
				    <input name="keyWord" type="text" value="${keyWord}" size="50"/>
				    <button>搜索</button>
			  	</form>
			</div>
			<!-- 显示所有书籍 -->
			<div id="tabs" style="Width:750px;background-color:white;">
				<ul>
					<li><a href="tabs-1">${firstName}</a></li>
				</ul>
				<div class="sales-queue" id="tabs-1" style="background-color:white;margin-top:-25px;">
				    <ul class="goods-queue3">
						<c:forEach items="${ArticleContext}" var="Article">
						<li id="selbgc11">
							<dl class="item-des">
							  <dt><a href="item.action?id=${Article.id}" title="${Article.title} " target="_self"><img src="images/article/${Article.image}" width="132" height="96" /></a></dt>
							  <dd><s>¥: ${Article.price}</s><strong>¥: ${Article.discountPrice}</strong></dd>
							  <dd><h2><a href="item.action?id=${Article.id}" title="${Article.title} " target="_self">${Article.description}</a></h2></dd>
							</dl>
						  </li>
						
						</c:forEach>
						 
						 
					</ul>
					<!-- 分页标签 -->
					<dp:page url="index.action" page="${page}"></dp:page>
					
				</div>
			</div>
		</div>
	</div>
	<!---- middle end----->
	
	<!--bottom part-->
	<div style="width: 1060px;margin: 0px auto;">
  		<img src="images/step.jpg"/>
  	</div>
</body> 
</html>