<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="#">English</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">中文</a>
            </li>
        </ul>
    </div>
    <div class="mx-auto order-0">
        <#if user??>
            <a class="navbar-brand mx-auto" href="#">${user.username}</a>
        </#if>
    </div>
    <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="/login">Logout</a>
            </li>
        </ul>
    </div>
</nav>

