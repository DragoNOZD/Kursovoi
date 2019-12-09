<#assign spring=JspTaglibs["http://www.springframework.org/tags"] />
<!DOCTYPE html>
<html>
        <head>
            <title>${login}</title>
            <link href="<@spring.url value ='/resources/css/basic.css' />" rel="stylesheet" type="text/css"/>
        </head>
    <body class="red">
        <div>
            <img src="${img}" alt="img">
            ${login}
        </div>
        <div>
            <#if edit = true>
                <a href="/users/${login}/settings">Edit account</a>
            </#if>
        </div>
    </body>
</html>