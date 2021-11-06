<#import "includes/common.ftlh" as p>

<@p.page>
    <div>
        <h3>author name:</h3>
        <h3>${author.authorname}</h3>
    </div>
    <br/>
    <h3>Question #${current_question.questionId}</h3>
    <div>
        <h5>${current_question.text}</h5>
    </div>
    <br/>
    <div class="form-group col-sm-6">
        <form method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <div class="form-group">
                <#if current_question.question_type=='TEXT'>
                    <label class="form-check-label">Answer field</label>
                    <input type="text" class="form-control"
                           name="question_text"/>
                <#elseif current_question.question_type=='SINGLE'>
                    <#list answer_options as option>
                        <div class="form-check">
                            <input class="form-check-input"
                                   type="radio" name="questionSingle" value="${option!''}"/>
                            <label class="form-check-label">${option}</label>
                        </div>
                    </#list>
                <#else>
                    <#list answer_options as option>
                        <div class="form-check form-check">
                            <label class="form-check-label">${option}</label>
                            <input class="form-check-input" type="checkbox" name="questionMulti" value="${option!''}"/>
                            <label class="form-check-label">${option}</label>
                        </div>
                    </#list>
                </#if>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary ml-2">Next question</button>
            </div>
        </form>
    </div>
</@p.page>