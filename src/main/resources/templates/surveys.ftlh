<#import "includes/common.ftlh" as p>

<@p.page>
    <h3>Available surveys</h3>
    <h3>
        <#if author.authorname=='default user'>
            for anonimous user with id ${author.id}
        <#else>
            ${author.authorname}
        </#if>
    </h3>
    <ul class="list-group">
        <#list questions as question>
            <li class="list-group-item">
                <a href="/surveys/${author.id}/${question.survey_id}/${question.questionId}">start ${question.surveyname}</a>
                <small> (all your previous data will be lost!)</small>
            </li>
        </#list>
    </ul>
</@p.page>