<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../../pages/public.jsp"/>
</head>
<body onload="startup();">
<div class="page">
    <div class="page login-page">
        <div class="container d-flex align-items-center">
            <div class="form-holder has-shadow">
                <div class="row">
                    <!-- Logo & Information Panel-->
                    <div class="col-lg-6">
                        <div class="info d-flex align-items-center">
                            <div class="content">
                                <div class="logo">
                                    <h1>门票管理系统</h1>
                                </div>
                                <p>The Menagerment of Travel Tickets </p>
                            </div>
                        </div>
                    </div>
                    <!-- Form Panel    -->
                    <div class="col-lg-6 bg-white">
                        <div class="form d-flex align-items-center">
                            <div class="content">
                                <form class="form-validate" method="post" id="form1">
                                    <input type="hidden" id="key" value="${aesKey}"/>
                                    <input type="hidden" id="iv" value="${aesIv}"/>
                                    <div class="form-group">
                                        <input id="login-username" type="text" name="loginUsername" required data-msg="请输入用户名" class="input-material">
                                        <label for="login-username" class="label-material">用户名</label>
                                    </div>
                                    <div class="form-group">
                                        <input id="login-password" type="password" name="loginPassword" required data-msg="请输入8位密码" class="input-material">
                                        <label for="login-password" class="label-material">密码</label>
                                    </div>
                                    <div style="display:none;" id="errorDiv"> </div>
                                    <%--<a id="login" class="btn btn-primary" >登录</a>--%>
                                    <div class="form-group">
                                        <button id="login" type="submit" name="loginSubmit" class="btn btn-primary" onclick="doLogin();">登录</button>
                                    </div>
                                    <!-- This should be submit button but I replaced it with <a> for demo purposes-->
                                </form>

                                <%--<a href="#" class="forgot-pass">忘记密码?</a><br><small>还没有账户? </small><a href="register.html" class="signup">注册</a>--%>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="copyrights text-center">
                <p>Design by <a href="javascript:void(0);" target="_blank" class="external">www.yiklv.com</a>
                    <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
                </p>
            </div>
        </div>
    </div>
    <script type="text/javascript">



        function startup() {
            var loginKey = Base64.encode('${aesKey}');
            var loginIv = Base64.encode('${aesIv}');
        }
        
        
        function checkLogin() {
            var loginUsername = document.getElementById("login-username").value;
            var loginPassword = document.getElementById("login-password").value;
            if(loginUsername && (loginUsername == null || loginUsername == '')
                && loginPassword&&(loginPassword == null || loginPassword == '') ){
                return false;
            }
            if(loginPassword.length != 8){
                return false;
            }
            return true;
        }
        function doLogin(){
            var loginUsername = document.getElementById("login-username").value;
            var loginPassword = document.getElementById("login-password").value;
            $("#errorDiv").show();
            if(loginUsername && (loginUsername == null || loginUsername == '')
                && loginPassword&&(loginPassword == null || loginPassword == '') ){
                $("#errorDiv").show();
                $("#errorDiv").append("<span style='font-color:red'>用户名或者密码不能为空</span>");
                return false;
            }
            if(loginPassword.length != 8){
                $("#errorDiv").show();
                $("#errorDiv").append("<span style='font-color:red'>密码长度必须为8位</span>");
                return false;
            }
            loginPassword = getAES(loginPassword);
            $.ajax({
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "${pageContext.request.contextPath}/login/login.do" ,//url
                data: {"loginUsername": loginUsername, "loginPassword": loginPassword},
                success: function (result) {
                    console.log(result);//打印服务端返回的数据(调试用)
                    if (result.resultCode == 200) {
                        alert("SUCCESS");
                    }
                },
                error : function() {
                    alert("异常！");
                }
            });
        }

    </script>

    <!-- JavaScript files-->
    <jsp:include page="../../pages/footer.jsp"/>
</body>
</html>