<html>
<head>
    <#include "../template/head.ftl">
</head>
<#--TODO Design cuk!-->
<#if user??>
    ${user.username}
</#if>
<#if (actionMessages?size>0)>
    <h1>${actionMessages[0]}</h1>
</#if>
<ul>
    <#list model as book>
        <li>${book.isbn}</li>
    </#list>
</ul>
<a href="/login">Logout</a>
</html>