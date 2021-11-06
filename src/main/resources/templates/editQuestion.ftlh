<#import "includes/common.ftlh" as p>
<#import "includes/createQuestionMacro.ftlh" as cq>

<@p.page>
    <#if message??>
        <div class="alert alert-danger col-sm-8" role="alert">
            ${message}
        </div>
    </#if>
    <h5>Question update</h5>
    <@cq.createQuestion "Edit"/>
</@p.page>