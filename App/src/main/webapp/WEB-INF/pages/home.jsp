<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=windows-1251" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <link href="<spring:url value="/resources/css/basic.css" />" rel="stylesheet"/>
        <link href="<spring:url value="/resources/css/login.css" />" rel="stylesheet"/>
    </head>
    <body class="red">
        <div>
	        <a class="login" href="${pageContext.request.contextPath}/login">Sign Up</a>
        </div>
    </body>
</html>
