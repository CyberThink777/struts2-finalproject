<html lang="${.lang}">
<head>
    <#include "../template/head.ftl">
    <title><@s.text name="welcome"/> ${user.username}!</title>
    <script>
        $(function () {
            $('[data-toggle="tooltip"]').tooltip()
        })
    </script>
</head>
<body>
<#include "../template/navbar.ftl">
<div class="container">
    <div class="row">
            <div class="col-sm-11">
                <h1 class="m-3"><@s.text name="index.heading"/></h1>
                <#include "../template/actionMsg.ftl">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col"><@s.text name="isbn"/></th>
                        <th scope="col"><@s.text name="title"/></th>
                        <th scope="col"><@s.text name="count"/></th>
                        <th scope="col"><@s.text name="editBy"/></th>
                    </tr>
                    </thead>
                    <tbody>
                    <#if (model?size>0)>
                        <#list model as book>
                            <tr>
                                <th scope="row">${book.isbn}</th>
                                <td>
                                    <a href="/book/${book.isbn}" data-toggle="tooltip" data-placement="top"
                                       title="<@s.text name='index.detail'/>">
                                        ${book.title}
                                    </a>
                                </td>
                                <td>${book.count}</td>
                                <td>${book.editBy}</td>
                            </tr>
                        </#list>
                    </#if>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <a href="/book/new"><@s.text name="index.create"/></a>
            </div>
        </div>
    </div>
</body>
</html>