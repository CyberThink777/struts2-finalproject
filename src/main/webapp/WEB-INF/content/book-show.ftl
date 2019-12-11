<html lang="${.lang}">
<#--TODO Design cuk!-->
<head>
    <#include "../template/head.ftl">
</head>
<body>
    <#include "../template/navbar.ftl">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <ul>
                    <li>${model.isbn}</li>
                    <li>${model.title}</li>
                    <li>${model.author}</li>
                    <li>${model.publisher}</li>
                    <li>${model.year?string["0000"]}</li>
                    <li>${model.count}</li>
                    <li>${model.editBy}</li>
                </ul>
                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteConfirm">
                    Delete
                </button>
            </div>
        </div>
    </div>
    <#include "../template/deleteConfirm.ftl">
</body>
</html>