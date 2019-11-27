<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=windows-1251" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Melee</title>
    <link href="<spring:url value="/resources/css/basic.css" />" rel="stylesheet"/>
    <link href="<spring:url value="/resources/css/forms.css" />" rel="stylesheet"/>
</head>
<body class="red">
<form class="loginForm" method="post" action="addMelee">
    <label>
        Name
        <input name="name" required="required"/>
    </label>
    <br/>
    <label>
        Pos
        <input name="pos" required="required"/>
    </label>
    <br/>
    <input type="submit" value="Add Melee" />
</form>
</body>
</html>