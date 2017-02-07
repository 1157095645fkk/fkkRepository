<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Lite - Bootstrap Skin</title>
	<!-- CSS -->
	<link href="${contextPath}/css/bootstrap.min.css" rel="stylesheet" />
	<link href="${contextPath}/css/style.css" rel="stylesheet" />
	<link href="${contextPath}/css/font-awesome.min.css" rel="stylesheet" />

	<!-- //for-mobile-apps -->
	<link href="${contextPath}/css/style2.css" rel="stylesheet" type="text/css" />
	<link href="${contextPath}/css/jquery-ui.css" rel="stylesheet" />

</head>

<body>
	<!-- header-->
   <div class="header">
	<div class="container">
		<div class="logo">
			<a href="${contextPath}/main/view.do">
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
<jsp:include page="dialog/myDialog.jsp"></jsp:include>

				<div>
					<div class="col-md-12">
						<h2 class="page-header"></h2>
					</div>
					<div class="col-md-12" style="margin-top:20px;">
					 <div class="center-div" style="width:60%;">
						<div class="lt-from lt-box">
                       <div class="form-group">
						   <blockquote style="margin-bottom:0px;padding-top:0px;padding-bottom:0px;">
							 <h3 style="padding-bottom:4px;padding-top:4px;">注册帐号</h3>
						   </blockquote>
						   <hr style="margin-top:0px;"/>
					   </div>
                         <div class="center-div" style="width:50%">
							 <div class="form-group">
								 <div>
									 <label class="hongxing">*</label><label>电话</label>
									 <input type="text" class="form-control" id="phone" name="userPhone" placeholder="手机号码"
											onfocus="phoneInput(this.value)"
											onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"
											onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'0')}else{this.value=this.value.replace(/\D/g,'')}">
								 </div>
								 <label id="phone_prompt" style="color: red;" hidden>*请输入正确的手机号码！</label>
							 </div>
							 <div class="form-group">
								 <div>
									 <label class="hongxing">*</label><label>验证码</label>
								 </div>
								 <div style="float: left">
									 <input type="text" class="form-control" style="width:100px;" id="verifyCode"
											placeholder="验证码"
											onfocus="verifyCodeInput(this.value)"
											onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^0-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"
											onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'0')}else{this.value=this.value.replace(/\D/g,'')}"
									 >
										 <label id="verifyCode_prompt" style="color: red;" hidden>*请输入正确的验证码！</label>
								 </div>
								 <div style="float: right;background-color: #4ea8f5; padding: 1px;">
									 <img id="verifyCodeImage" onclick="reloadVerifyCode()"
										  src="${contextPath}/login/getVerifyCodeImage.do"/><br/>
								 </div>
							</div>
								<div class="form-group">
									<br/>
									<div>
										<br/>
										<div>
											<label class="hongxing">*</label>
											<label>手机验证码</label>
										</div>
									<div>&nbsp;
										<div style="float: left;">
											<input type="text" class="form-control" id="phoneCode" name="phoneCode"
												   placeholder="输入手机验证码"
												   onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^0-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"
												   onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'0')}else{this.value=this.value.replace(/\D/g,'')}">
										</div>
										<%--只允许输入字母和数字--%>
										<%--onkeyup="value=value.replace(/[\W]/g,'')"
                                        onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">--%>
										<div style="float: right; ">
											<a class="btn btn-primary-alt" id="btn_getPhoneCode" onclick="getPhoneCode(this)">获取验证码</a>
										</div>
									</div>
									</div>
								</div>
								<div class="form-group">
									<div style="padding-top: 15px;">
									<label>用户名</label>
									<input type="text" class="form-control" id="userName" name="userName" placeholder="userName"
										   oninput="userNameDangerChar(this.value)">
									<label id="userName_error_prompt" style="color: red;" hidden>* 用户名中不能包含特殊字符！</label>
									</div>
								</div>
								<div class="form-group">
									<label class="hongxing">*</label><label>密码</label>
									<input type="password" class="form-control" id="password" name="userPassword" placeholder="Password"
										   onchange="passwordDangerChar(this.value)"
									       oninput="pwd_different(this.value)">
									<label id="password_error_prompt" style="color: red;" hidden>* 密码中不能包含特殊字符！</label>
									<label id="password_length_prompt" style="color: red;" hidden>* 密码不能小于6位！</label>
								</div>
								<div class="form-group">
									<label class="hongxing">*</label><label>确认密码</label>
									<input type="password" class="form-control" id="rePassword" name="rePassword" placeholder="rePassword"
										   onchange="rePasswordDangerChar(this.value)"
									       oninput="pwd_different(this.value)">
									<label id="rePassword_error_prompt" style="color: red;" hidden>* 密码中不能包含特殊字符！</label>
									<label id="pwd_diffent" style="color: red;" hidden>* 两次密码输入不一致！</label>
								</div>

			                     <div class="form-group">
								   <div style="float:left">
								    <label>姓别</label>
								    </div> 
								    <div class="radio-custom radio-warning" style="float:left;margin-left:20px;">
									    <input type="radio" id="man" name="userSex" value="1" checked>
									    <label>男</label>
								    </div>

								    <div class="radio-custom radio-danger" style="float:left;margin-left:20px;">
									     <input type="radio" id="woman" name="userSex" value="2">
									     <label>女</label>
								    </div>
									<br />
                               </div>

								<div class="form-group">
								 <div>
									<label>邮箱</label>
									<input type="text" class="form-control" id="email" name="userEmail" placeholder="email"
										   oninput="emailCheck()">
									 <label id="email_error_prompt" style="color: red;" hidden>* 邮箱格式错误</label>
								 </div>
								</div>
							 <div style="padding-top: 15px;">
							     <%--<div class="checkbox-custom checkbox-success">
								 <input type="checkbox" id="checkboxExample3">
								 <label for="checkboxExample3">Checkbox Success</label>
								 </div>--%>
								<a class="btn btn-primary-alt" onclick="submit_data(this)">Submit</a>
                               </div>

						</div>
					</div>
				    </div>
               </div>
    <!-- End: Main Content -->

    <!-- Javascript Files -->
    <script type="text/javascript" src="${contextPath}/js/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="${contextPath}/js/jquery-ui.js"></script>
    <script type="text/javascript" src="${contextPath}/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${contextPath}/js/md5.js"></script>
    <script type="text/javascript" src="${contextPath}/js/view_js/myDialog.js"></script>
	<script type="text/javascript" src="${contextPath}/js/main.js"></script>
	<script language="javascript" type="text/javascript" >

						var alllowSubmit = true;

						/*验证用户输入是否合法*/
						function emailCheck() {
							var objName = document.getElementById("email");
							var pattern = /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
							if (objName.value!=""&&!pattern.test(objName.value)) {
								objName.focus();
								$("#email_error_prompt").show();
								alllowSubmit = false;
							}else {
								$("#email_error_prompt").hide();
								alllowSubmit = true;
							}
						}

						function dangerChar(str,id) {
							var resultTag = 0;
							var flag = 0;
							var pattern=/[`~!@#\$%\^\&\*\(\)_\+<>\?:"\{\},\.\\\/;'\[\]]/im;
							if(pattern.test(str)) {
								resultTag = resultTag + 1;
							}

							if(str!=""&&resultTag!=flag){
								$(id).show();
								alllowSubmit = false;
							}else{
								$(id).hide();
								alllowSubmit = true;
							}
						}
						function userNameDangerChar(str) {
							dangerChar(str,"#userName_error_prompt");
						}
						function passwordDangerChar(str) {
							dangerChar(str,"#password_error_prompt");
							//验证输入长度
							var tem1 = $("#password").val().length;
							if(tem1<6){
								$("#password_length_prompt").show();
								alllowSubmit = false;
							}else {
								$("#password_length_prompt").hide();
								alllowSubmit = false;
							}
						}
						function rePasswordDangerChar(str) {
							dangerChar(str,"#rePassword_error_prompt");
						}
						function pwd_different(str) {
							if($("#rePassword").val()!=$("#password").val()){
								$("#pwd_diffent").show();
								alllowSubmit = false;
							}else{
								$("#pwd_diffent").hide();
								alllowSubmit = true;
							};
						}
						//验证码输入验证
						function verifyCodeInput(str){
							$("#verifyCode_prompt").hide();
						}
						//手机输入验证
						function phoneInput() {
							$("#phone_prompt").hide();
						}
						var  wait = 120;
						//获取手机验证码
						function getPhoneCode(o) {
							if($("#phone").val()==""||$("#phone").val().length!=11){
								$("#phone_prompt").show();
								return;
							};

							if($("#verifyCode").val()==""||$("#verifyCode").val().length!=4){
								$("#verifyCode_prompt").show();
								return;
							};

							var phone = {
								userPhone:$("#phone").val(),
								verifyCode:$("#verifyCode").val()
							};
							$.ajax({
							 url:"${contextPath}/register/getPhoneCode.do",  //在struts2里为action名字（注：action本身就代表一个路径）
							 type:'get',
							 data:phone, //需要传送到后台的数据  如果是表单则可以写：data: $("#myform").serialize()
							 success:function(data){
							 if(data.code==1) {
								 prompt_dialog(data.msg+"");
								 time(o);
							 }else if(data.code==2){
								 prompt_dialog(data.msg+"");
							 }
							 },
							 error:function(data){
								 prompt_dialog(data.msg+"");
							 }
							 });
						}
						//120倒计时 递归
						function time(o) {
							/**
							 * 倒计时
							 */
							if (wait == 0) {
								o.removeAttribute("disabled");
								o.text = "获取验证码";
								wait = 120;
							} else {

								o.setAttribute("disabled", true);
								o.text="重新发送(" + wait + ")";
								wait--;
								setTimeout(function() {
											time(o)
										},
										1000)
							}
						}

						/*结束---验证用户输入是否合法---结束*/
						function submit_data(o){

							//检查数据是否合法
							if(alllowSubmit==false){
								prompt_dialog("输入数据不合法");
								return;
							}
							var phoneCode = $("#phoneCode").val().length;
							var phone = $("#phone").val().length;
							var verifyCode =$("#verifyCode").val().length;
							if(phoneCode!=6||phone!=11||verifyCode!=4){
								prompt_dialog("手机验证码为6位! 手机号为11位! 验证码为4位!");
								return;
							}

							var data = $("#register_form").serialize();
							var test = {
								/**
								 * 用户id
								 */
								userId:0,
								/**
								 * 用户名
								 */
								userName:$("#userName").val(),
								/**
								 *手机验证码
								 */
								phoneCode:$("#phoneCode").val(),
								/**
								 * 用户密码
								 */
								userPassword:$("#password").val(),
								/**
								 * 再次确认密码
								 */
								rePassword:$("#rePassword").val(),
								/**
								 * 用户性别
								 */
								userSex:$("input[name='userSex']:checked").val(),
								/**
								 * 用户手机号
								 */
								userPhone:$("#phone").val(),
								/**
								 * 用户e-mail
								 */
								userEmail:$("#email").val(),
								/**
								 * 验证码
								 */
								verifyCode:$("#verifyCode").val()
							};
							$.ajax({
								url:"${contextPath}/register/submit.do",  //在struts2里为action名字（注：action本身就代表一个路径）
								type:'get',
								data:test,    //需要传送到后台的数据  如果是表单则可以写：data: $("#myform").serialize()
								success:function(data){
									if(data.code==1) {
										prompt_dialog(data.msg+"");
										var params = {
											userPhone:$("#phoneCode").val(),
											password:$("#password").val(),
											verifyCode:$("#verifyCode").val()
										}
										$.ajax({
											url:'${contextPath}/login/loginVerify.do?', //在struts2里为action名字（注：action本身就代表一个路径）
											type:'post',
											data:params,    //需要传送到后台的数据  如果是表单则可以写：data: $("#myform").serialize()
											dataType:'json', //返回值类型
											success:function(data){
												var d = eval("("+data+")"); //这里标示将返回的数据直接当js代码来运行
												alert(d);
												alert("success");
												alert(data);
												alert(d.aaa+"测试");//获取json里面的值
											}
										});
									}else if(data.code==2){
										prompt_dialog(data.msg+"");
									}
								},
								error:function(data){
									prompt_dialog(data.msg+"，返回失败！");
								}
							});
						}
						//刷新验证码
						function reloadVerifyCode() {
							document.getElementById('verifyCodeImage').setAttribute('src', '${contextPath}/login/getVerifyCodeImage.do?' + new Date().getMilliseconds());
						}
					</script>
</body>
</html>