<html lang="${.lang}">
<#--TODO Design cuk!-->
<head>
    <#include "../template/head.ftl">
    <title>${model.title}</title>
</head>
<body>
    <#include "../template/navbar.ftl">
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <ul class="list-group">
                    <li class="list-group-item"><@s.text name="isbn"/>: ${model.isbn}</li>
                    <li class="list-group-item"><@s.text name="title"/>: ${model.title}</li>
                    <li class="list-group-item"><@s.text name="author"/>: ${model.author}</li>
                    <li class="list-group-item"><@s.text name="publisher"/>: ${model.publisher}</li>
                    <li class="list-group-item"><@s.text name="year"/>: ${model.year?string["0000"]}</li>
                    <li class="list-group-item"><@s.text name="count"/>: ${model.count}</li>
                    <li class="list-group-item"><@s.text name="editBy"/>: ${model.editBy}</li>
                </ul>
                <a href="/book/${id}/edit" class="btn btn-outline-primary">Edit</a>
                <button type="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#deleteConfirm">
                    <@s.text name="button.delete"/>
                </button>
            </div>
        </div>
    </div>
    <#include "../template/deleteConfirm.ftl">
</body>
</html>