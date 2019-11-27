<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 15.10.2019
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=windows-1251" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
    <link href="<spring:url value="/resources/css/basic.css" />" rel="stylesheet"/>
    <link href="<spring:url value="/resources/css/forms.css" />" rel="stylesheet"/>
</head>
<body class="red">
<form class="loginForm" method="post" action="purchaseCheck">
    <label>
        Login
        <input name="userLogin" required="required"/>
    </label>
    <br/>
    <label>
        Game
        <input name="gameID" required="required"/>
    </label>
    <br/>
    <input type="submit" value="Buy" />
</form>
</body>
</html>
