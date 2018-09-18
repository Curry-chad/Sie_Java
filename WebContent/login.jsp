<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<style type="text/css">
        table
        {
            border-collapse: collapse;
            margin: 0 auto;
            text-align: center;
        }
        table td, table th
        {
            /*border: 1px solid #cad9ea;*/
            color: #666;
            height: 30px;
        }
        table thead th
        {
            background-color: #CCE8EB;
            width: 100px;
        }
        table tr:nth-child(odd)
        {
            background: #fff;
        }
        table tr:nth-child(even)
        {
            background: #F5FAFA;
        }
    </style>
</head>
<body>
<% 
if(session.getAttribute("msg")!=null)
{

   response.sendRedirect("welcome.jsp");
}
%>
<h1 style="text-align: center">登录页面</h1>
<form action="login" method="post">
    <table>
        <tr><td>用户名：</td><td><input type="text" name="loginName" placeholder="4-12位的数字和字母" required onblur="Namevalidate()"></td><td><span id="1"></span></td></tr>
        <tr><td>密码：</td><td><input type="password" name="password" placeholder="6-12位的数字和字母" required onblur="Pwdvalidate()"></td><td><span id="2"></span></td></tr>
        <tr>
            <td><input type="submit" id="sumbit" value="登录" onclick="return Formvalidate()"></td>
            <td><input type="reset" value="重置"></td>
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
            return false;
        }
        else  
        {
            a.innerHTML="";
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
</script>
</html>