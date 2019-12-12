<html lang="${.lang}">
<head>
    <#include "../template/head.ftl">
    <title>${model.title}</title>
    <style>
        .top-m {
            margin:10% auto 0% auto;
        }
    </style>
</head>
<body>
    <#include "../template/navbar.ftl">
    <div class="container">
        <div class="row">
            <div class="col-sm-6 top-m">
                <#include "../template/actionMsg.ftl">
                <ul class="list-group">
                    <li class="list-group-item"><@s.text name="isbn"/>: ${model.isbn}</li>
                    <li class="list-group-item"><@s.text name="title"/>: ${model.title}</li>
                    <li class="list-group-item"><@s.text name="author"/>: ${model.author}</li>
                    <li class="list-group-item"><@s.text name="publisher"/>: ${model.publisher}</li>
                    <li class="list-group-item"><@s.text name="year"/>: ${model.year?string["0000"]}</li>
                    <li class="list-group-item"><@s.text name="count"/>: ${model.count}</li>
                    <li class="list-group-item"><@s.text name="editBy"/>: ${model.editBy}</li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-6 d-flex flex-row-reverse mt-3 top-m">
                <button type="button" class="btn btn-outline-danger ml-3" data-toggle="modal"
                        data-target="#deleteConfirm">
                    <@s.text name="button.delete"/>
                </button>
                <a href="/book/${id}/edit" class="btn btn-outline-primary"><@s.text name="index.edit"/></a>
            </div>
        </div>
    </div>
    <#include "../template/deleteConfirm.ftl">
</body>
</html>