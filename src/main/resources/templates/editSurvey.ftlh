<#import "includes/common.ftlh" as p>
<#import "includes/EditSurveyMacro.ftlh" as es>

<@p.page>
    <h5>Survey edit</h5>
    <@es.editSurvey "Edit"/>
    <ul class="list-group">
        <#list questions as question>
            <li class="list-group-item">
                <p>${question.text}</p>
                <a class="btn btn-primary mb-2" href="/surveyApp/admin/edit/${survey_id}/editQuestion?question=${question.id}">Edit question</a>
                <a class="btn btn-danger mb-2" href="/surveyApp/admin/delete/${question.id}">Delete question</a>
            </li>
            <#else>
                <h5>${message!''}</h5>
        </#list>
    </ul>
    <br/>
    <a class="btn btn-primary mb-2" href="/surveyApp/admin/edit/${survey_id}/createQuestion">Add question</a>
</@p.page>