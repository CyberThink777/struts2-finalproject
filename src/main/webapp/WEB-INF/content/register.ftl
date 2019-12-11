<html lang="${.lang}">
<head>
    <#include "../template/head.ftl"/>
    <title><@s.text name="register.title"/></title>
    <style>
        .col-centered{
            float: none;
            margin: 20% auto;
        }

        .alert:empty {
            display: none;
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
<div class="container">
    <div class="row">
        <div class="col-sm-4 col-centered">
            <h2 class="mx-auto"><@s.text name="register.form"/></h2>
            <form action="register" method="POST">
                <#include "../template/actionMsg.ftl">
                <div class="form-group">
                    <@s.textfield class="form-control" name="username" key="user.username"
                    placeholder="%{getText('form.username')}"/>
                </div>
                <div class="form-group">
                    <@s.password class="form-control" name="pass" key="user.pass"
                    placeholder="%{getText('form.pass')}"/>
                </div>
                <div class="form-group">
                    <@s.password class="form-control" name="cpass" key="user.cpass"
                    placeholder="%{getText('user.cpass')}"/>
                </div>
                <button type="submit" class="btn btn-primary"><@s.text name="form.submit"/></button>
                <button type="reset" class="btn btn-secondary"><@s.text name="form.reset"/></button>
            </form>
            <div>
    <span>
        <a href="/login"><@s.text name="register.login"/></a>
    </span>
                <span class="float-right">
        <a href="?request_locale=en_US">English</a>
        <a href="?request_locale=zh_CN">中文</a>
    </span>
            </div>
        </div>
    </div>
</div>
</body>
</html>