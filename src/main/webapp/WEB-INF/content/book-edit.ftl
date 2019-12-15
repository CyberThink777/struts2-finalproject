<html lang="${.lang}">
<head>
    <#include "../template/head.ftl">
    <title><@s.text name="index.edit"/> ${id}</title>
    <style>
        .top-m {
            margin: 10% auto 0% auto;
        }

        .errorMessage {
            display: inherit;
            color: red;
        }
    </style>
    <script>
        $(document).ready(function () {
            $(".errorMessage").siblings("input").addClass("is-invalid");
        })
    </script>
</head>
<body>
<#include "../template/navbar.ftl">
<div class="container">
    <div class="row">
        <div class="col-sm-6 top-m">
            <h2 class="mx-auto"><@s.text name="index.edit"/></h2>
            <form method="POST" action="/book/${id}">
                <input type="hidden" name="_method" value="PUT"/>
                <div class="form-group">
                    <@s.textfield class="form-control-plaintext" name="isbn" key="isbn" value="${model.isbn}"
                    readonly="true" dynamicAttributes={"aria-describedby":"isbnHelp"}/>
                    <small id="isbnHelp" class="form-text text-muted"><@s.text name="isbn.help"/></small>
                </div>
                <div class="form-group">
                    <@s.textfield class="form-control" name="title" key="title" value="${model.title}"/>
                </div>
                <div class="form-group">
                    <@s.textfield class="form-control" name="author" key="author" value="${model.author}"/>
                </div>
                <div class="form-group">
                    <@s.textfield class="form-control" name="publisher" key="publisher" value="${model.publisher}"/>
                </div>
                <div class="form-group">
                    <@s.textfield class="form-control" name="year" key="year" value="${model.year?string['0000']}"/>
                </div>
                <div class="form-group">
                    <@s.textfield class="form-control" name="count" key="count" value="${model.count}"/>
                </div>
                <button type="submit" class="btn btn-primary"><@s.text name="button.submit"/></button>
                <button type="reset" class="btn btn-secondary" onclick="window.location.href = '/book/${id}/edit' ">
                    <@s.text name="form.reset"/>
                </button>
            </form>
        </div>
    </div>
</div>
</body>
</html>