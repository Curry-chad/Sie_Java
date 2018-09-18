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
<title>角色新增页面</title>
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
	<form action="RoleSave" method="post">
		<table>
			<tr>
				<td>角色名：</td>
				<td><input type="text" name="role" placeholder="4-12位的数字和字母"
					required></td>
				<td><span id="1"></span></td>
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
				<td><input type="submit" id="sumbit" value="确定"></td>
				<td><input type="reset" value="取消" onclick="cancel()"></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
    function cancel()
    {
    	
    	 window.history.back();
    }
</script>
</html>