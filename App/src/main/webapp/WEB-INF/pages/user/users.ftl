<#assign spring=JspTaglibs["http://www.springframework.org/tags"] />
<!DOCTYPE html>
<html>
    <head>
        <title>Users</title>
        <link href="<@spring.url value ='/resources/css/basic.css' />" rel="stylesheet" type="text/css"/>
    </head>
    <body class="red">
        <div>
            <table>
                <#list accounts as Account>
                    <tr>
                        <td>
                            <img src="${Account.image}" alt="img">
                        </td>
                        <td>
                            <a class="red" href="users/${Account.login}">${Account.name}</a>
                        </td>
                    </tr>
                </#list>
            </table>
        </div>
    </body>
</html>
