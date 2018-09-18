<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<style type="text/css">
table {
	border-collapse: collapse;
	margin: 0 auto;
	text-align: center;
}

table td, table th {
	/*border: 1px solid #cad9ea;*/
	color: #666;
	height: 30px;
}

table thead th {
	background-color: #CCE8EB;
	width: 100px;
}

table tr:nth-child(odd) {
	background: #fff;
}

table tr:nth-child(even) {
	background: #F5FAFA;
}

a {
	text-decoration: none;
}
</style>
</head>
<body>
	<%SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss"); %>
	<h1>新增</h1>
	<hr>
	<form action="index" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="loginName"
					placeholder="4-12位的数字和字母" required onblur="Namevalidate()"></td>
				<td><span id="1"></span></td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td><input type="text" name="name" required
					onblur="Namevalidate()"></td>
				<td><span id="1"></span></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"
					placeholder="6-12位的数字和字母" required onblur="Pwdvalidate()"></td>
				<td><span id="2"></span></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><input id="man" type="radio" checked="checked" name="sex"
					value="男" />男<input id="woman" type="radio" name="sex" value="女" />女</td>
				<td><span></span></td>
			</tr>
			<tr>
				<td>邮箱地址：</td>
				<td><input type="email" name="email" required></td>
				<td><span id="3"></span></td>
			</tr>
			<tr>
				<td>备注：</td>
				<td><textarea name="detail" id="" cols="30" rows="10"></textarea><span
					id="4"></span></td>
			</tr>
			<tr>
				<td>创建时间：</td>
				<td><%=format.format(new Date())%></td>
				<td><span></span></td>
			</tr>
			<tr>
				<td><input type="submit" id="sumbit" value="确定"
					onclick="return Formvalidate()"></td>
				<td><input type="reset" value="取消" onclick="cancel()"></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
    function Namevalidate()
    {

        var loginName=document.getElementsByName("loginName")[0].value;
        var password=document.getElementsByName("password")[0];
        var a=document.getElementById("1");
         var reg=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{4,12}$/;
        if(reg.test(loginName)!=true)
        {
            a.innerHTML="用户名格式不正确";
           password.disabled=true;
            return false;
        }
        else
        {

            a.innerHTML="";
            password.disabled=false;
            return true;
        }

    }
    function Pwdvalidate()
    {
        var password=document.getElementsByName("password")[0].value;
        var reg1=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$/;
        var b=document.getElementById("2");
        if(reg1.test(password)!=true)
        {
            b.innerHTML="密码格式不正确";
            return false;
        }
        else
        {
            b.innerHTML="";
            return true;
        }

    }
    function Formvalidate()
    {
        return Namevalidate()&&Pwdvalidate();
        var sub=document.getElementById("submit");
        sub.setAttribute("disabled",true);

    }
    function a()
    {

        window.showModalDialog("D:\HTML Files\poll.html");
    }
    function cancel()
    {
    	
    	 window.history.back();
    }
</script>
</html>
</html>