<#--TODO Design cuk!-->
<#if user??>
    ${user.username}
</#if>
<#--${model.author}-->
<ul>
    <#list model as book>
        <li>${book.isbn}</li>
    </#list>
</ul>
<a href="/login">Logout</a>