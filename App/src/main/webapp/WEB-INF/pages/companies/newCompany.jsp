<%--
  Created by IntelliJ IDEA.
  User: DragoNOZD
  Date: 10/12/2019
  Time: 19:56
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
<form class="login" method="post" action="NewCompanyCheck">
    <label>
        INN
        <input name="inn" required="required"/>
    </label>
    <br/>
    <label>
        Name
        <input name="name" required="required"/>
    </label>
    <br/>
    <input type="submit" value="Add Company" />
</form>
</body>
</html>