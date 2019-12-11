<#if (actionMessages?size>0)>
    <div class="alert alert-success my-1 p-1 pl-2" id="msg" role="alert">${actionMessages[0]}</div>
</#if>
<#if (actionErrors?size>0)>
    <div class="alert alert-danger my-1 p-1 pl-2" id="msg" role="alert">${actionErrors[0]}</div>
</#if>