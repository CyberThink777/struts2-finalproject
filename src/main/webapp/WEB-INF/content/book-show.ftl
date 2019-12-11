<html lang="${.lang}">
<#--TODO Design cuk!-->
<head>
    <#include "../template/head.ftl">
</head>
<#include "../template/navbar.ftl">
<ul>
    <li>${model.isbn}</li>
    <li>${model.title}</li>
    <li>${model.author}</li>
    <li>${model.publisher}</li>
    <li>${model.year?string["0000"]}</li>
    <li>${model.count}</li>
    <li>${model.editBy}</li>
</ul>
<a href="/login">Logout</a>
</html>