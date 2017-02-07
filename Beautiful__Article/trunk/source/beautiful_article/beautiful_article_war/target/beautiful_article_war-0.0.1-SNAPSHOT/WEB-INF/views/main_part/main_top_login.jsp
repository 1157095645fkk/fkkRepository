<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/16 0016
  Time: 下午 2:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>head</title>

    <link href="${contextPath}/css/bootstrap.css" rel="stylesheet"/>
    <link href="${contextPath}/css/font-awesome.min.css" rel="stylesheet"/>
    <link href="${contextPath}/css/style.css" rel="stylesheet"/>

    <script type="text/javascript" src="${contextPath}/js/jquery-1.10.2.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {

        });
        function reloadVerifyCode() {
            document.getElementById('verifyCodeImage').setAttribute('src', '${contextPath}/login/getVerifyCodeImage.do?' + new Date().getMilliseconds());
        }
    </script>

</head>
<body>
<div class="header">
    <div class="container">
        <div class="logo">
            <a href="index.html">
                <span>F</span>IELD LIFE
            </a>
        </div>
        <div class="social-icons">
            <ul>
                <li><a class="facebook" href="#"></a></li>
                <li><a class="twitt" href="#"></a></li>
                <li><a class="link" href="#"></a></li>
                <li><a class="googl" href="#"></a></li>
                <li><a class="dribb" href="#"></a></li>
            </ul>
        </div>
    </div>
</div>
<!-- stop header -->
<div><h2 class="page-header"></h2></div>
<div>
    <nav role="navigation" class="navbar navbar-inverse lite-nav">
        <div class="navbar-header">
            <button data-target="#bs-example-navbar-collapse-2" data-toggle="collapse" class="navbar-toggle"
                    type="button">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="#" class="navbar-brand">Brand Name</a>
        </div>
        <div id="bs-example-navbar-collapse-2" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home <i class="fa fa-home"></i></a></li>
                <li><a href="#">About <i class="fa fa-calendar"></i></a></li>
                <li><a href="#">Services <i class="fa fa-cogs"></i></a></li>
                <li><a href="#">Contact Us <i class="fa fa-phone"></i></a></li>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${contextPath}/register/view.do">注册</a></li>
                <li class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">登录<b class="caret"></b></a>
                    <ul role="menu" class="dropdown-menu">
                        <li class="divider"></li>
                        <div class="login">
                            <form role="form">
                                <div class="form-group">
                                    <label style="color:#fff">帐号</label>
                                    <input type="email" class="form-control" style="width:200px;" id="InputAccount"
                                           placeholder="Enter email">
                                </div>
                                <div class="form-group">
                                    <label style="color:#fff">密码</label>
                                    <input type="password" class="form-control" style="width:200px;" id="InputPassword"
                                           placeholder="Password">
                                </div>
                                <div class="form-group">
                                    <div>
                                        <label style="color:#fff">验证码</label>
                                    </div>
                                    <div style="float: left">
                                        <input type="text" class="form-control" style="width:100px;" id="verifyCode"
                                               placeholder="Password">
                                    </div>
                                    <div style="float: right;">
                                        <img id="verifyCodeImage" onclick="reloadVerifyCode()"
                                             src="${contextPath}/login/getVerifyCodeImage.do"/><br/>
                                    </div>
                                </div>
                                <li><a href="#" class="btn btn-info">登&nbsp;录</a></li>
                            </form>
                        </div>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</div>
</body>
</html>
