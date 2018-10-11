<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/common.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/login/login.js"></script>
<script type="text/javascript">
	function changeVToken(){
		$("#_vTokenName").val("");
		$("#_vTokenNameImg").attr("src", "${pageContext.request.contextPath}/login/getImageCode.do" + "?random=" + Math.random());
	}
	
	function cleanInput(){
		document.getElementById("user_id").value = "";
		document.getElementById("_vTokenName").value = "";
		document.getElementById("password").value = "";
	}
	
	
	function showErrorMsg(message){
		var errorDiv = $("#errorDiv");
		var errorMsg = $("#errorMsg");
		errorMsg.html(message);
		errorDiv.show();
	}
	function hiddenErrorMsg(){
		var errorDiv = $("#errorDiv");
		var errorMsg = $("#errorMsg");
		errorMsg.html("");
		errorDiv.hide();
	}
	
	function submitLogin(){
		hiddenErrorMsg();
		var userId  = document.getElementById("user_id").value;
		var password = document.getElementById("password").value;
		var _vTokenName = document.getElementById("_vTokenName").value;
		if(!isNullCheck(userId)){
			showErrorMsg("用户名不能为空！");
			return;
		}
		if(!isNullCheck(password)){
			showErrorMsg("请输入密码！");
			return;
		}
		if(!isNullCheck(_vTokenName)){
			showErrorMsg("请输入验证码");
			return;
		}
		var _vToken  = document.getElementById("_vToken").value;
		var _vKeyVal  = document.getElementById("_vKeyVal").value;
		var contextPath = '${pageContext.request.contextPath}';
		var encrypted = encrypt(password, _vKeyVal, _vKeyVal);
		var encrytoPwd = encrypted.ciphertext.toString();
		
		disableButton($("#submitForm"));
		jQAjax({
			url: contextPath + "/login/login.do",
			data:{
				userId: userId,
				password: encrytoPwd,
				_vTokenName: _vTokenName,
				_vToken: _vToken
			},
			type: "POST",
			dataType: "json",
			cache: false,
			success: function(data, status){
				unDisableButton($("#submitForm"));
				//var result = eval("("+ data +")"); //  $.parseJSON(data);
				var result = data;
				var resultFlag = result.Success;
				
				if(resultFlag =='S'){
					window.location.href = contextPath+"/index/indexAction.do";
				}
				else{
					_flushToken(contextPath,$('#_vToken'));
					changeVToken();
					cleanInput();
					showErrorMsg(result.SuccessMsg);
				}
			},
			error: function(req, textStatus, errorThrown){
				unDisableButton($("#submitForm"));
				console.log(req);
				console.log(textStatus);
				console.log(errorThrown);
			}
			
		});
	}
</script>
</head>
<body>

<div id="pc-header">
	<div class="center">
		<div class="pc-fl-logo">
			<h1>
				<a href="index.html"></a>
			</h1>
		</div>
	</div>
</div>
	<div class="pc-login-bj">
		<div class="center clearfix">
			<div class="fl"></div>
			<div class="fr pc-login-box">
				<div class="pc-login-title"><h2>用户登录</h2></div>
				<form action="javascript:void(0);" id="formId">
					<input type="hidden" id="_vKeyVal" name="_vKeyVal" value="${AESKEY }"/>
					<input type="hidden" name="_vToken" id="_vToken" value="${_vToken}">
					<input type="hidden" name="_rootPath" id="_rootPath" value="${pageContext.request.contextPath}">
					<div class="pc-sign">
						<input type="text" name="user_id" id="user_id" placeholder="用户名/邮箱/手机号" autocomplete="off"/>
					</div>
					<div class="pc-sign">
						<input type="password" namem="password" id="password" placeholder="请输入您的密码">
					</div>
					<div class="pc-sign-vtoken">
						<input type="text" name="_vTokenName" id="_vTokenName" placeholder="请输入验证码"  autocomplete="off"/>
						<img src="<%= request.getContextPath()%>/login/getImageCode.do?random=1" onclick="changeVToken()" id="_vTokenNameImg" name="_vToken"/>
					</div>
					<div class="pc-submit-ss">
						<input type="submit" value="登录" placeholder="" onclick="submitLogin();" id="submitForm">
					</div>
					<div id="errorDiv" style="display:none;text-align: center;padding-top: 13px;">
						<span id="errorMsg" style="color: red;font-size: 14px;"></span>
					</div>
					<div class="pc-item-san clearfix">
						<a href="#"><img src="../img/icon/weixin.png" alt="">微信登录</a>
						<a href="#"><img src="../img/icon/weibo.png" alt="">微博登录</a>
						<a href="#" style="margin-right:0"><img src="../img/icon/tengxun.png" alt="">QQ登录</a>
					</div>
					<div class="pc-reg">
						<a href="#">忘记密码</a>
						<a href="register.html" class="red">免费注册</a>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="center">
		<div class="pc-footer-login">
			<p>关于我们 招聘信息 联系我们 商家入驻 商家后台 商家社区 ©2017 Yungouwu.com 北京云购物网络有限公司</p>
			<p style="color:#999">营业执照注册号：990106000129004 | 网络文化经营许可证：北网文（2016）0349-219号 | 增值电信业务经营许可证：京2-20110349 | 安全责任书 | 京公网安备 99010602002329号 </p>
		</div>
	</div>

</body>
</html>