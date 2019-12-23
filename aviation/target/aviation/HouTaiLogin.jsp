<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>航空管理系统</title>
<link rel="stylesheet" type="text/css" href="css/Laylogin.css">
</head>
<body>
	<div
		style="width: 700px; margin-left: auto; margin-right: auto; margin-top: 50px;">
		<span style="float: left;"></span>
		<h1 style="float:left;margin-left: 230px; color: #fff; font-size: 40px;">航空管理系统</h1>
	</div>
	<div id="wrapper" class="login-page">
		<div id="login_form" class="form">
			<form class="login-form">
				<h2>航空管理系统</h2>
				<input type="text" placeholder="用户名"  id="user_name" />
				<input type="password" placeholder="密码" id="password"  />
				<button id="login">登 录</button>&nbsp&nbsp&nbsp&nbsp
				<p class="message">
				</p>
			</form>
		</div>
	</div>

	<script src="js/jquery.min.js"></script>
	<script>
		function check_login() {
			//登录的方法
			var account = $("#user_name").val();
			var password =$("#password").val();
			console.log(account+""+password);
			$.ajax({
				url:"/Admin/ajaxdenglu",
				type:"GET",
				data:{"username":account,"password":password},
				success:function(data){
				    console.log(data);
					var result = data;
					if (result=="true") {
						$("#user_name").val("");
						$("#password").val("");
						$(location).attr('href', '../index.jsp');
					} else {
						
						$("#user_name").val("");
						$("#password").val("");
						$("#login_form").removeClass('shake_effect');
						setTimeout(function() {
							$("#login_form").addClass('shake_effect')
						}, 1);
					}
				}
			})
			
		}
		$(function() {
			$("#login").click(function() {
				if($("#user_name").val()==""||$("#password").val()==""){
					
					$("#login_form").removeClass('shake_effect');
					setTimeout(function() {
						$("#login_form").addClass('shake_effect')
					}, 1);
				}else{
					check_login();
					return false;
				}
				
				
			})
			$('.message a').click(function() {
				$('form').animate({
					height : 'toggle',
					opacity : 'toggle'
				}, 'slow');
			});
		})
	</script>
</body>
</html>