
<#macro createQuestion  button>
    <div class="form-group col-sm-6">
        <form method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <div class="form-group">
                <label class="form-check-label">Question text</label>
                <input type="text" class="form-control"
                       value="<#if question??>${question.getText()}</#if>"
                       name="text" placeholder="question text"/>
            </div>
            <div class="form-group">
                <#list questionTypes as qtype>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="question_type"
                               value="${qtype}"/>
                        <label class="form-check-label">${qtype}</label>
                    </div>
                </#list>
            </div>
            <div class="form-group">
                <label class="form-check-label">Answer options for question</label>
                <input type="text" class="form-control"
                       value="<#if question??>${question.getAnswerOptions()}</#if>"
                       name="answer_options" placeholder=""/>
            </div>

            <div class="form-group">
                <label class="form-check-label">Right answer for question</label>
                <input type="text" class="form-control"
                       value="<#if question??>${question.getRightAnswers()}</#if>"
                       name="right_answers" placeholder=""/>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary ml-2">${button}</button>
            </div>
        </form>
    </div>
</#macro>