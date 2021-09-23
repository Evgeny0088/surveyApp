<#import "includes/common.ftlh" as p>

<@p.page>

    <h5>Admin page</h5>
    <ul class="list-group">
        <#list surveys as survey>
            <li class="list-group-item">
                <p class="message-text">${survey.sname}</p>
                <a class="btn btn-primary mb-2" href="/surveyApp/admin/edit/${survey.id}">Edit</a>
                <a class="btn btn-danger mb-2" href="/surveyApp/admin/survey/delete/${survey.id}">Delete</a>
            </li>
        </#list>
    </ul>
    <div>
        <a class="btn btn-primary mb-2" href="/surveyApp/admin/createSurvey">Create new Survey</a>
    </div>

</@p.page>