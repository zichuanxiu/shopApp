<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>购物商城-购物车</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="fkjava.ico" rel="shortcut icon" type="image/x-icon" />
		<!-- main.css是购物商城主样式 -->
		<link rel=stylesheet type=text/css href="css/main.css"/>
		<!-- header.js输出头部信息 -->
		<script type="text/javascript" src="js/header.js"></script>
		<script type="text/javascript">
			// 从购物车中删除物品
			var deleteFn = function(id){
				window.location.href = "deleteCar.action?id=" + id;
			};
			/** id: 物品的ID, num: 购买的数量 , type : 是加一还是减一*/
			var addFun = function(id, num, type){
				// 购买的数量
				var buyNum = parseInt(num);
				if (buyNum == 1 && type == 2){
					return;
				}
				switch (type){
					case 1: // 增加一个
						window.location.href = "updateCar.action?id=" + id + "&buyNum=" + (buyNum+1);
						break;
					case 2: // 减少一个
						window.location.href = "updateCar.action?id=" + id + "&buyNum=" + (buyNum-1);
						break;
				}
			};
			var blurFn = function(obj, id, num){
				if (isNaN(obj.value)){
					obj.value = num;
				}else if (obj.value < 1){
					obj.value = num;
				}else if (obj.value != num){
					window.location.href = "updateCar.action?id=" + id + "&buyNum=" + obj.value;
				}
			};
		</script>
	</head>
<body>
	<!-- header部分 -->
	<div id="shortcut">
		<script type="text/javascript">header("");</script>
	﻿	<div class="nav">
			<div class="w960 center">
				<ul>
					<li><a title="首页" href="index.action">首页</a></li>
					
						<li><a title="护肤" href="/fk_ec/index.action?typecode=0001">护肤</a></li>
					
						<li><a title="彩妆" href="/fk_ec/index.action?typecode=0002">彩妆</a></li>
					
						<li><a title="香氛" href="/fk_ec/index.action?typecode=0003">香氛</a></li>
					
						<li><a title="身体护理" href="/fk_ec/index.action?typecode=0004">身体护理</a></li>
					
						<li><a title="礼盒套装" href="/fk_ec/index.action?typecode=0005">礼盒套装</a></li>
					
						<li><a title="母婴专区" href="/fk_ec/index.action?typecode=0006">母婴专区</a></li>
					
						<li><a title="男士专区" href="/fk_ec/index.action?typecode=0007">男士专区</a></li>
					
						<li><a title="粉底" href="/fk_ec/index.action?typecode=0008">粉底</a></li>
					
						<li><a title="粉饼" href="/fk_ec/index.action?typecode=0009">粉饼</a></li>
					
						<li><a title="睫毛膏" href="/fk_ec/index.action?typecode=0010">睫毛膏</a></li>
					
						<li><a title="唇彩" href="/fk_ec/index.action?typecode=0011">唇彩</a></li>
					
						<li><a title="腮红" href="/fk_ec/index.action?typecode=0012">腮红</a></li>
					
						<li><a title="食品保健" href="/fk_ec/index.action?typecode=0013">食品保健</a></li>
					
						<li><a title="瘦身类" href="/fk_ec/index.action?typecode=0014">瘦身类</a></li>
					
						<li><a title="美容类" href="/fk_ec/index.action?typecode=0015">美容类</a></li>
					
				</ul>
			</div>
		</div>
	</div>
	<!--header end-->
	
	<!-- middle part -->
	<div style="positon: relative; width: 960px;margin: 0px auto;">
		<div class="shoppingcart_wrapper" id="shoppingcart">
	        <p style="text-align:left;"><span id="shoppingcart_dd" style="font-size:13px;line-height:28px;">当前位置&nbsp;&gt;&gt;&nbsp;我的购物车 </span></p>
	        <ul class="shoppingcart_subject" id="ui_shoppingcart_title">
	            <li class="row1">商品名称</li>
	            <li class="row2">积分</li>
	            <li class="row3">疯狂价</li>
	            <li class="row4"><span title="在疯狂价基础上再优惠">&nbsp;&nbsp;&nbsp;小计&nbsp;&nbsp;&nbsp;</span></li>
	            <li class="row5">数量</li>
	            <li class="row6">操作</li>
	        </ul>
	        
	        <!-- 购物车不为空 -->
	        
	        <!-- 购物车为空的话 -->
	        
		        	<table align="center">
		        		<tr>
		        			<td><img alt="" src="images/cart_icon.gif"/></td>
		        			<td>
		        				<span style="font-size:14px;font-weight:bold;">
		        					购物车为空，<a href="index.action">我要去看看&gt;&gt;</a>
		        				</span>
		        			</td>
		        		</tr>
		        	</table>
	        
      	</div>
	</div>
	<!---- middle end----->
	
	<!--bottom part-->
	<div style="width: 1060px;margin: 0px auto;">
  		<img src="images/step.jpg"/>
  	</div>
</body> 
</html>