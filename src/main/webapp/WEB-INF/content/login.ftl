<html lang="${.lang}">
<head>
    <#include "../template/head.ftl"/>
    <title><@s.text name="login.title"/></title>
    <style>
        body {
            width: 20%;
            position: absolute;
            top: 20%;
            left: 40%;
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
<h2 class="mx-auto"><@s.text name="login.form"/></h2>
<form action="login" method="POST">
    <#if (actionMessages?size>0)>
        <div class="alert alert-success my-1 p-1 pl-2" id="msg" role="alert">${actionMessages[0]}</div>
    </#if>
    <#if (actionErrors?size>0)>
        <div class="alert alert-danger my-1 p-1 pl-2" id="msg" role="alert">${actionErrors[0]}</div>
    </#if>
    <div class="form-group">
        <@s.textfield class="form-control" name="username" key="user.username"
        placeholder="%{getText('form.username')}"/>
    </div>
    <div class="form-group">
        <@s.password class="form-control" name="pass" key="user.pass"
        placeholder="%{getText('form.pass')}"/>
    </div>
    <button type="submit" class="btn btn-primary"><@s.text name="form.submit"/></button>
    <button type="reset" class="btn btn-secondary"><@s.text name="form.reset"/></button>
</form>
<div>
    <span>
        <a href="/register"><@s.text name="login.register"/></a>
    </span>
    <span class="float-right">
        <a href="?request_locale=en_US">English</a>
        <a href="?request_locale=zh_CN">中文</a>
    </span>
</div>
</body>
</html>