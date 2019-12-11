<nav class="navbar navbar-expand-sm sticky-top navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".dual-collapse2">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="?request_locale=en_US">English</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="?request_locale=zh_CN">中文</a>
            </li>
        </ul>
    </div>
    <div class="mx-auto order-0">
        <#if user??>
            <a class="navbar-brand mx-auto" href="/book"><@s.text name="book.title"/> ${user.username}!</a>
        </#if>
    </div>
    <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="btn btn-sm btn-outline-light" href="/login"><@s.text name="logout"/></a>
            </li>
        </ul>
    </div>
</nav>

