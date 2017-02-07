<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>登录界面</title>
    <script src="${contextPath}/js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript">
        <!--
        function reloadVerifyCode() {
            document.getElementById('verifyCodeImage').setAttribute('src', '${pageContext.request.contextPath}/login/getVerifyCodeImage');
        }
        //-->
    </script>
</head>

<div style="color:red; font-size:22px;">${message_login}</div>

<form action="<%=request.getContextPath()%>/mydemo/login" method="POST">
    姓名：<input type="text" name="username"/><br/>
    密码：<input type="text" name="password"/><br/>
    验证：<input type="text" name="verifyCode"/>
    &nbsp;&nbsp;
    <img id="verifyCodeImage" onclick="reloadVerifyCode()" src="<%=request.getContextPath()%>/login/getVerifyCodeImage"/><br/>
    <input type="submit" value="确认"/>
</form>
</html>