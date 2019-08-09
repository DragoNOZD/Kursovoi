<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
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
			<form method="post" action="main">
				<label>
					Login
					<input name="login" />
				</label>
				<br/>
				<label>
					Name
					<input name="name" />
				</label>
				<br/>
				<input type="submit" value="login" />
			</form>
		</body>
</html>
