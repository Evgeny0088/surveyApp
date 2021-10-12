<#import "includes/common.ftlh" as p>
<#import "includes/loginMacro.ftlh" as lm>

<@p.page>
    <#if message??>
        <div class="alert alert-danger col-sm-8" role="alert">
            ${message}
        </div>
    </#if>
    <@lm.login "/surveyApp/login"/>

</@p.page>