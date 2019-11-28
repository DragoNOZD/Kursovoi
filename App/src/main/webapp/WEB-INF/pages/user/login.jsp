<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=windows-1251" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Login</title>
		<link href="<spring:url value="/resources/css/basic.css" />" rel="stylesheet"/>
		<link href="<spring:url value="/resources/css/forms.css" />" rel="stylesheet"/>
	</head>
	<body class="red">
		<div class="warnings">
			${warning}
		</div>
		<form class="loginForm" method="post" action="loginCheck">
			<label>
				Login
				<input name="login" required="required"/>
			</label>
			<br/>
			<label>
				Password
				<input type="password" name="password" required="required"/>
			</label>
			<br/>
			<label>
				<input type="checkbox" name="remember-me"/>
				Remember me
			</label>
			<br/>
			<input type="submit" value="Login" />
		</form>
	</body>
</html>
