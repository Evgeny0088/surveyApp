<#import "includes/common.ftlh" as p>
<#import "includes/EditSurveyMacro.ftlh" as es>

<@p.page>
    <#if message??>
        <div class="alert alert-danger col-sm-8" role="alert">
            ${message}
        </div>
    </#if>
    <h5>Survey create</h5>
    <@es.editSurvey "Create"/>
</@p.page>