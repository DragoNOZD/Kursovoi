<%--
  Created by IntelliJ IDEA.
  User: DragoNOZD
  Date: 10/12/2019
  Time: 19:18
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
        <div class="warnings">
            ${warning}
        </div>
        <form class="loginForm" method="post" action="signUpCheck">
            <label>
                Login
                <input name="login" required="required"/>
            </label>
            <br/>
            <label>
                Name
                <input name="name" required="required"/>
            </label>
            <label>
                Password
                <input type="password" name="password" required="required"/>
            </label>
            <br/>
            <input type="submit" value="Sign Up" />
        </form>
    </body>
</html>
