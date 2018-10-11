<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../common/common.jsp"></jsp:include>

</head>
<body>

<header id="pc-header">
	<div class="center">
		<div class="pc-fl-logo">
			<h1>
				<a href="index.html"></a>
			</h1>
		</div>
	</div>
</header>
<section>
	<div class="pc-login-bj">
		<div class="center clearfix">
			<div class="fl"></div>
			<div class="fr pc-login-box">
				<div class="pc-login-title"><h2>用户注册</h2></div>
				<form action="">
					<div class="pc-sign">
						<input type="text" placeholder="邮箱/手机号">
					</div>
					<div class="pc-sign">
						<input type="password" placeholder="请输入您的密码">
					</div>
					<div class="pc-sign">
						<input type="password" placeholder="请确认您的密码">
					</div>
					<div class="pc-sign">
						<input type="password" placeholder="请输入您的验证码">
					</div>
					<div class="pc-submit-ss">
						<input type="submit" value="立即注册" placeholder="">
					</div>
					<div class="pc-item-san clearfix">
						<a href="#"><img src="../img/icon/weixin.png" alt="">微信登录</a>
						<a href="#"><img src="../img/icon/weibo.png" alt="">微博登录</a>
						<a href="#" style="margin-right:0"><img src="../img/icon/tengxun.png" alt="">QQ登录</a>
					</div>
					<div class="pc-reg">

						<a href="login.html" class="red">已有账号 请登录</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</section>
<footer>
	<div class="center">
		<div class="pc-footer-login">
			<p>关于我们 招聘信息 联系我们 商家入驻 商家后台 商家社区 ©2017 Yungouwu.com 北京云购物网络有限公司</p>
			<p style="color:#999">营业执照注册号：990106000129004 | 网络文化经营许可证：北网文（2016）0349-219号 | 增值电信业务经营许可证：京2-20110349 | 安全责任书 | 京公网安备 99010602002329号 </p>
		</div>
	</div>
</footer>

</body>
</html>