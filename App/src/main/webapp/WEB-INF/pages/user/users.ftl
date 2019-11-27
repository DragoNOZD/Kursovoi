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
        <div>
            <#if prevPage??>
                <a href="users?countPerPage=${countPerPage}&page=${prevPage}">Previous</a>
            </#if>
            <#list pages as p>
                <a href="users?countPerPage=${countPerPage}&page=${p}">${p+1}</a>
            </#list>
            <#if nextPage??>
                <a href="users?countPerPage=${countPerPage}&page=${nextPage}">Next</a>
            </#if>
        </div>
        <div>
            CountPerPage:
            <a href="users?countPerPage=20&page=0">20 </a>
            <a href="users?countPerPage=30&page=0">30 </a>
            <a href="users?countPerPage=50&page=0">50 </a>
            <a href="users?countPerPage=100&page=0">100 </a>
        </div>
    </body>
</html>
