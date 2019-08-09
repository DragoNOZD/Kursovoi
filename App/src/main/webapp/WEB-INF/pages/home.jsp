<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <link href="<spring:url value="/resources/css/basic.css" />" rel="stylesheet"/>
        <link href="<spring:url value="/resources/css/login.css" />" rel="stylesheet"/>
    </head>
    <body class="red">
        <div>
	        <a class="login" href="${pageContext.request.contextPath}/login">Login</a>
	        <a class="login" href="${pageContext.request.contextPath}/login2">Test</a>
	        <script src="<spring:url value="/resources/js/newHello.js" />"></script>
        </div>
    </body>
</html>
