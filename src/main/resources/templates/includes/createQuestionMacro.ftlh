
<#macro createQuestion  button>
    <div class="form-group col-sm-6">
        <form method="post">
            <div class="form-group">
                <label class="form-check-label">Question text</label>
                <input type="text" class="form-control ${(textError??)?string('is-invalid','')}"
                       value="${text!''}"
                       name="text" placeholder="question text"/>
                <#if textError??>
                    <div class="invalid-feedback">${textError}</div>
                </#if>
            </div>
            <div class="form-group">
                <#list questionTypes as qtype>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="question_type"
                               value="${question_type!qtype}"/>
                        <label class="form-check-label">${qtype}</label>
                    </div>
                </#list>
            </div>
            <div class="form-group">
                <label class="form-check-label">Answer options for question</label>
                <input type="text" class="form-control ${(answer_optionsError??)?string('is-invalid','')}"
                       value="${answerOptions!''}"
                       name="answer_options" placeholder="description"/>
                    <#if answer_optionsError??>
                    <div class="invalid-feedback">${answer_optionsError}</div>
                </#if>
            </div>

            <div class="form-group">
                <label class="form-check-label">Right answer for question</label>
                <input type="text" class="form-control ${(right_answersError??)?string('is-invalid','')}"
                       value="${rightAnswers!''}"
                       name="right_answers" placeholder="description"/>
                <#if right_answersError??>
                    <div class="invalid-feedback">${right_answersError}</div>
                </#if>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary ml-2">${button}</button>
            </div>
        </form>
    </div>
</#macro>