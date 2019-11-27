<%--
  Created by IntelliJ IDEA.
  User: DragoNOZD
  Date: 10/11/2019
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=windows-1252" %>
<!DOCTYPE html>
<html>
    <head>
        <title>${login}</title>
        <link href="<spring:url value="/resources/css/basic.css" />" rel="stylesheet"/>
    </head>
    <body class="red">
        <div>
            <p>Hello, ${login}</p>
        </div>
    </body>
</html>
