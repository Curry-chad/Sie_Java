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
	<h1>菜单新增</h1>
	<hr>
	<form action="MenuSave" method="post">
		<table>
			<tr>
				<td>类型：</td>
				<td><input type="radio" name="type" value="目录">目录</td>
				<td><input type="radio" name="type" value="菜单">菜单</td>
				<td><input type="radio" name="type" value="按钮">按钮</td>
			</tr>
			<tr>
				<td>菜单名称：</td>
				<td><input type="text" name="menuName"></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>上级菜单：</td>
				<td><select name="lastMenu">option>主页</option>
						<option>用户管理</option><option>角色管理</option><option>菜单管理</option></select></td>
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>菜单地址：</td>
				<td><input type="text" name="address"></td>
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>授权标识：</td>
				<td><input type="text" name="signal"></td>
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>备注：</td>
				<td><textarea name="remark" id="" cols="30" rows="10"></textarea></td>
				</td>
				<td></td>
				<td></td>
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
