<html lang="${.lang}">
<#--TODO Design cuk!-->
<head>
    <#include "../template/head.ftl">
    <title></title>
</head>
<#include "../template/navbar.ftl">
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