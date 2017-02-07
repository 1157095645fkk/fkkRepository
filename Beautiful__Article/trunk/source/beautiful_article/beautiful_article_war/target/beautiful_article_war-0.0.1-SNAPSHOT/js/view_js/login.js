/**
 * Created by fkk on 2016/12/9.
 */
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
        password:password,
        verifyCode:verifyCode
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
}