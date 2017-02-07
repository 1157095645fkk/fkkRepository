<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Lite - Bootstrap Skin</title>
    <!-- Favicon -->
    <link rel="shortcut icon" href="${contextPath}/img/favicon.ico"/>

    <!-- CSS -->
    <link href="${contextPath}/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${contextPath}/css/bootstrap.css" rel="stylesheet"/>
    <link href="${contextPath}/css/font-awesome.min.css" rel="stylesheet"/>
    <link href="${contextPath}/css/style.css" rel="stylesheet"/>

    <!-- //for-mobile-apps -->
    <link href="${contextPath}/css/style2.css" rel="stylesheet" type="text/css"/>

    <!-- Javascript Files -->
    <script defer src="${contextPath}/js/jquery.flexslider.js"></script>
    <script type="text/javascript" src="${contextPath}/js/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="${contextPath}/js/jquery.pagination.js"></script>
    <script type="text/javascript" src="${contextPath}/js/jquery.knob.min.js"></script>
    <script type="text/javascript" src="${contextPath}/js/main.js"></script>
    <!-- for bootstrap working -->
    <script type="text/javascript" src="${contextPath}/js/bootstrap.min.js"></script>

    <script type="text/javascript" src="${contextPath}/js/view_js/login.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {

        });
        function reloadVerifyCode() {
            document.getElementById('verifyCodeImage').setAttribute('src', '${contextPath}/login/getVerifyCodeImage.do?' + new Date().getMilliseconds());
        }
        function login() {
            var userPhone = $("#userPhone").val();
            var password = $("#password").val();
            var verifyCode = $("#verifyCode").val();
            var params = {
                userPhone:userPhone,
                userPassword:password,
                verifyCode:verifyCode
            }
            $.ajax({
                url:'${contextPath}/login/loginVerify.do', //在struts2里为action名字（注：action本身就代表一个路径）
                type:'post',
                data:params,    //需要传送到后台的数据  如果是表单则可以写：data: $("#myform").serialize()
                success:function(data){
                    if(data.code==1){
                        prompt_dialog(data.msg+"");
                    }else if(data.code==2){
                        prompt_dialog(data.msg+"");
                    }
                },
                error:function (data) {
                    prompt_dialog("请求错误!");
                }
            });
        }
        function userNameDangerChar(str) {
            dangerChar(str,"#password");
        }
    </script>

</head>

<body>
<!-- //head -->
<jsp:include flush="true" page="main_part/main_top_unlogin.jsp"></jsp:include>

<!-- header-->
<%--<div class="header">
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
</div>--%>
<!-- stop header -->
<%--<div><h2 class="page-header"></h2></div>
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
</div>--%>
<!-- banner -->
<div>
    <div class="banner">
        <div class="container">
            <section class="slider">
                <div class="flexslider">
                    <ul class="slides">
                        <li>
                            <div class="banner-info">
                                <div class="banner-text">
                                    <h3>MAKE YOUR FARM PROFITABLE</h3>
                                    <p>Itaque earum rerum hic tenetur a sapiente delectus,
                                        ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis
                                        doloribus asperiores repellat.</p>
                                    <a class="hvr-bounce-to-bottom" href="single.html">READ MORE</a>
                                </div>
                                <div class="banner-text">
                                    <h3>STEADY GROWTH FOR YOUR FARM</h3>
                                    <p>Itaque earum rerum hic tenetur a sapiente delectus,
                                        ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis
                                        doloribus asperiores repellat.</p>
                                    <a class="hvr-bounce-to-bottom" href="single.html">READ MORE</a>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                        </li>
                    </ul>
                </div>
            </section>
            <!--End-slider-script-->
        </div>
    </div>
</div>
<!-- //banner -->
<!-- welcome -->
<div class="welcome">
    <div class="container">
        <div class="wel-header">
            <h3>OUR BEGINNING</h3>
            <p>Repellat earum rerum hic tenetur a sapiente delectus,
                ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis
                doloribus asperiores repellat.</p>
        </div>
        <div class="wel-grids">
            <div class="col-md-4 wel-grid text-center">
                <div class="btm-clr">
                    <figure class="icon">
                        <span class="glyphicon glyphicon-grain" aria-hidden="true">唐</span>
                    </figure>
                    <h3>OUR PROFILE</h3>
                    <p> Nemo enim ipsam voluptatem
                        quia voluptas sit aspernatur aut
                        odit aut fugi.</p>
                </div>
            </div>
            <div class="col-md-4 wel-grid btm-gre text-center">
                <div class="btm-clr">
                    <figure class="icon">
						<span class="glyphicon glyphicon-globe" aria-hidden="true">
						</span>
                    </figure>
                    <h3>ECO SOLUTIONS</h3>
                    <p> Nemo enim ipsam voluptatem
                        quia voluptas sit aspernatur aut
                        odit aut fugi.</p>
                </div>
            </div>
            <div class="col-md-4 wel-grid text-center">
                <div class="btm-clr">
                    <figure class="icon">
                        <span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
                    </figure>
                    <h3>PURE ORGANIC</h3>
                    <p> Nemo enim ipsam voluptatem
                        quia voluptas sit aspernatur aut
                        odit aut fugi.</p>
                </div>
            </div>
            <div class="col-md-4 wel-grid btm-gre text-center">
                <div class="btm-clr">
                    <figure class="icon">
                        <span class="glyphicon glyphicon-leaf" aria-hidden="true">sss</span>
                    </figure>
                    <h3>SEEDS & TRAITS</h3>
                    <p> Nemo enim ipsam voluptatem
                        quia voluptas sit aspernatur aut
                        odit aut fugi.</p>
                </div>
            </div>
            <div class="col-md-4 wel-grid text-center">
                <div class="btm-clr">
                    <figure class="icon">
                        <span class="glyphicon glyphicon-tree-conifer" aria-hidden="true">干</span>
                    </figure>
                    <h3>NEW TECHOLOGIES</h3>
                    <p> Nemo enim ipsam voluptatem
                        quia voluptas sit aspernatur aut
                        odit aut fugi.</p>
                </div>
            </div>
            <div class="col-md-4 wel-grid btm-gre text-center">
                <div class="btm-clr">
                    <figure class="icon">
                        <span class="glyphicon glyphicon-apple" aria-hidden="true"></span>
                    </figure>
                    <h3>PRODUCTS</h3>
                    <p> Nemo enim ipsam voluptatem
                        quia voluptas sit aspernatur aut
                        odit aut fugi.</p>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!-- //welcome -->
<jsp:include flush="true" page="main_part/index-bottom1.jsp"></jsp:include>

</body>
</html>
