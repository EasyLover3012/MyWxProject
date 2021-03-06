<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 因为jsp servlet版本问题，2.3及2.3之前的版本isELIgnored默认是true,true即是EL表达式出现在文本或者标签属性时被忽略，当字符串显示在页面。2.3以后的版本默认是false -->
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="css/sso_login.css" />
</head>
<body class="blue">

	<form name="form1" action="login.do" method="post" onsubmit="return save()">
	
		<div id="main">
			<div id="right-side" class="inner-login" style="margin-left: 120px;">
				<div style="margin: 23px 0px 23px 2px; height: 40px; line-height: 40px; overflow: hidden;">
					<img src="image/logo-small.jpg" style="max-width: 40px" />
					<span style="font-size: 19px;"><strong>生产配件收发明细登记系统</strong></span>
				</div>
				<div class="u-name" style="text-align: left">
					<input name="loginName" type="text" id="loginName" tabindex="1" class="username" placeholder="用户名">
				</div>
				<div class="u-pwd" style="text-align: left">
					<input name="loginPwd" type="password" id="loginPwd" tabindex="2" class="password" placeholder="密码">
				</div>
				<div style="text-align: left">
					<input type="submit" name="submit" value="登  录" id="submit" tabindex="3" class="submit">
				</div>
				<div><span style="color: red;">${info }</span></div>
			</div>
		</div>
		
	</form>
	
</html>