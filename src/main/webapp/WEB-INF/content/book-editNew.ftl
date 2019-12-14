<html lang="${.lang}">
<head>
    <#include "../template/head.ftl">
    <title><@s.text name="index.create"/></title>
    <style>
        .top-m {
            margin:10% auto 0% auto;
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
                <h2 class="mx-auto"><@s.text name="index.create"/></h2>
                <form method="POST" action="/book">
                    <div class="form-group">
                        <@s.textfield class="form-control" name="isbn" key="isbn"/>
                    </div>
                    <div class="form-group">
                        <@s.textfield class="form-control" name="title" key="title"/>
                    </div>
                    <div class="form-group">
                        <@s.textfield class="form-control" name="author" key="author"/>
                    </div>
                    <div class="form-group">
                        <@s.textfield class="form-control" name="publisher" key="publisher"/>
                    </div>
                    <div class="form-group">
                        <@s.textfield class="form-control" name="year" key="year"/>
                    </div>
                    <div class="form-group">
                        <@s.textfield class="form-control" name="count" key="count"/>
                    </div>
                    <button type="submit" class="btn btn-primary"><@s.text name="button.submit"/></button>
                    <button type="reset" class="btn btn-secondary"
                            onclick="window.location.reload()"><@s.text name="form.reset"/></button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>