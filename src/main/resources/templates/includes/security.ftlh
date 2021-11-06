<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>
<#if known>
    <#assign
    admin = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    username = admin.getUsername()
    isActive = admin.isEnabled()
    >
<#else>
    <#assign
    username = "anomimous user"
    >
</#if>