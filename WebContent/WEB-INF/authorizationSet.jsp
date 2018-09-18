<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>设置权限</title>
<link rel="StyleSheet" href="dtree.css" type="text/css" />
<script type="text/javascript" src="dtree.js"></script>
</head>
<body>
	<div class="dtree">

		<script type="text/javascript">
		<!--

		d = new dTree('d');
		d.check = true;  
		d.add(0,-1,'主页');
		d.add(1,0,'用户管理','authorizationSet.jsp');
		d.add(2,0,'角色管理','authorizationSet.jsp');
		d.add(4,0,'菜单管理','authorizationSet.jsp');
		d.add(3,1,'查询','authorizationSet.jsp');
		d.add(13,1,'重置','authorizationSet.jsp');
		d.add(14,1,'新增','authorizationSet.jsp');
		d.add(15,1,'批量删除','authorizationSet.jsp');
		d.add(16,1,'修改','authorizationSet.jsp');
		d.add(17,1,'删除','authorizationSet.jsp');
		d.add(18,1,'设置角色','authorizationSet.jsp'); 
		d.add(5,2,'查询','authorizationSet.jsp');
		d.add(6,2,'重置','authorizationSet.jsp');
		d.add(7,2,'新增','authorizationSet.jsp');
		d.add(8,2,'批量删除','authorizationSet.jsp');
		d.add(9,2,'修改','authorizationSet.jsp','Pictures I\'ve taken over the years','','','img/imgfolder.gif');
		d.add(19,2,'删除','authorizationSet.jsp','Pictures of Gullfoss and Geysir');
		d.add(20,2,'设置权限','authorizationSet.jsp');
		d.add(21,4,'查询','authorizationSet.jsp','','','img/trash.gif');
		d.add(22,4,'重置','authorizationSet.jsp','','','img/trash.gif');
		d.add(23,4,'新增','authorizationSet.jsp','','','img/trash.gif');
		d.add(24,4,'批量删除','authorizationSet.jsp','','','img/trash.gif');
		d.add(25,4,'修改','authorizationSet.jsp','','','img/trash.gif');
		d.add(26,4,'删除','authorizationSet.jsp','','','img/trash.gif');

		

		document.write(d);
		document.write('<input type="button" value="确定" onclick="AuthoritySet()" > <input type="button" value="取消" onclick="cancel()"> ');
		alert(d.selectedNode);
		function cancel()
		{
			
			 window.history.back();
		}
		function AuthoritySet()
		{
			if (confirm("您确定要更改吗？更改后数据库中的记录随之更改！")) {
				var num = d.selectedNode;
				alert(d.selectedNode[0]);
				var arr = new Array();
				var sum = 0;
				for (var i = 0; i < num.length; i++) {

					if (num[i].checked == true) {
						arr[sum] = num[i].value;
						sum++;
					}
				}
				window.location.href = "MenuRoleModify?rid=${Role.rid}&&mid=" + arr + "";
			}
			
		}

		//-->
	</script>
     
	</div>
	
</body>
<!-- <script type="text/javascript">

</script> -->
</html>