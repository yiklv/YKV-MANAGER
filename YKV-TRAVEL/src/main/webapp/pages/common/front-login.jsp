<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<div class="pc-header-nav">
	<div class="pc-header-con">
		<div class="fl pc-header-link">
			<c:if test="${ sessionScope.sessionAdmin == null }">
			您好！，欢迎来云购物
				<a href="${pageContext.request.contextPath}/login/loginPage.do" >请登录</a> 
				<a href="${pageContext.request.contextPath}/login/registerPre.do"> 免费注册</a>
			</c:if>
			<c:if test="${ sessionScope.sessionAdmin != null }">
				您好！${sessionScope.sessionAdmin.userName}，欢迎来云购物 
				<a href="${pageContext.request.contextPath}/login/logout.do"> 注销</a>
			</c:if>
		</div>
		<div class="fr pc-header-list top-nav">
			<ul>
				<li>
					<div class="nav">
						<i class="pc-top-icon"></i><a href="#">我的订单</a>
					</div>
					<div class="con">
						<dl>
							<dt>
								<a href="">批发进货</a>
							</dt>
							<dd>
								<a href="">已买到货品</a>
							</dd>
							<dd>
								<a href="">优惠券</a>
							</dd>
							<dd>
								<a href="">店铺动态</a>
							</dd>
						</dl>
					</div>
				</li>
				<li>
					<div class="nav">
						<i class="pc-top-icon"></i><a href="#">我的商城</a>
					</div>
					<div class="con">
						<dl>
							<dt>
								<a href="">批发进货</a>
							</dt>
							<dd>
								<a href="">已买到货品</a>
							</dd>
							<dd>
								<a href="">优惠券</a>
							</dd>
							<dd>
								<a href="">店铺动态</a>
							</dd>
						</dl>
					</div>
				</li>
				<li><a href="#">我的云购</a></li>
				<li><a href="#">我的收藏</a></li>
				<li><a href="#">会员中心</a></li>
				<li><a href="#">客户服务</a></li>
				<li><a href="#">帮助中心</a></li>
			</ul>
		</div>
	</div>
</div>
<div class="pc-header-logo clearfix">
	<div class="pc-fl-logo fl">
		<h1>
			<a href="index.html"></a>
		</h1>
	</div>
	<div class="head-form fl">
		<form class="clearfix">
			<input class="search-text" accesskey="" id="key" autocomplete="off"
				placeholder="洗衣机" type="text">
			<button class="button" onclick="search('key');return false;">搜索</button>
		</form>
		<div class="words-text clearfix">
			<a href="#" class="red">1元秒爆</a> <a href="#">低至五折</a> <a href="#">农用物资</a>
			<a href="#">佳能相机</a> <a href="#">服装城</a> <a href="#">买4免1</a> <a
				href="#">家电秒杀</a> <a href="#">农耕机械</a> <a href="#">手机新品季</a>
		</div>
	</div>
	<div class="fr pc-head-car">
		<i class="icon-car"></i> <a href="my-car.html" target="_blank">我的购物车</a>
		<em>10</em>
	</div>
</div>

