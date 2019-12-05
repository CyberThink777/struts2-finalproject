<html>
<head>
    <#include "../template/head.ftl">
</head>
<#--TODO Design cuk!-->
<#if user??>
    ${user.username}
</#if>
<ul>
    <li>${model.isbn}</li>
    <li>${model.title}</li>
    <li>${model.author}</li>
    <li>${model.publisher}</li>
    <li>${model.year}</li>
    <li>${model.count}</li>
    <li>${model.editBy}</li>
</ul>
<a href="/login">Logout</a>
</html>