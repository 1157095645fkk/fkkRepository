<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/13 0013
  Time: 下午 2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${contextPath}/js/jquery-1.9.1.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            var aaa ="${name}";
            alert(aaa);
        });
        function reloadVerifyCode() {
            document.getElementById('verifyCodeImage').setAttribute('src', 'getVerifyCodeImage.do');
        }
    </script>
</head>
<body>
<div style="color:red; font-size:22px;">${name}</div>
<div style="color:red; font-size:22px;">${books}</div>
<div style="color:red; font-size:22px;">${contextPath}+"----"</div>

<form action="mydemo/login" method="POST">
    姓名：<input type="text" name="username"/><br/>
    密码：<input type="text" name="password"/><br/>
    验证：<input type="text" name="verifyCode"/>
    &nbsp;&nbsp;
    <img id="verifyCodeImage" onclick="reloadVerifyCode()" src="getVerifyCodeImage.do"/><br/>
    <input type="submit" value="确认"/>
    </form>
</body>
</html>
