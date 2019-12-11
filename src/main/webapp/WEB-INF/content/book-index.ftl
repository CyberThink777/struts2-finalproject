<html lang="${.lang}">
<#--TODO Add get new-->
<head>
    <#include "../template/head.ftl">
    <title><@s.text name="book.title"/> ${user.username}!</title>
</head>
<body>
    <#include "../template/navbar.ftl">
    <div class="container">
        <div class="row">
            <div class="col-11">
                <h1 class="m-3"><@s.text name="index.heading"/></h1>
                <#include "../template/actionMsg.ftl">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col"><@s.text name="isbn"/></th>
                        <th scope="col"><@s.text name="title"/></th>
                        <th scope="col"><@s.text name="count"/></th>
                        <th scope="col"><@s.text name="editBy"/></th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <#if (model?size>0)>
                        <#list model as book>
                            <tr>
                                <th scope="row">${book.isbn}</th>
                                <td>${book.title}</td>
                                <td>${book.count}</td>
                                <td>${book.editBy}</td>
                                <td><a href="/book/${book.isbn}"><@s.text name="index.detail"/></a></td>
                            </tr>
                        </#list>
                    </#if>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="row">
            <a href="/book/new">Create</a>
        </div>
    </div>
</body>
</html>