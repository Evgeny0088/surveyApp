
<#macro editSurvey  button>
    <div class="form-group col-sm-6">
        <form method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <div class="form-group">
                <input type="text" class="form-control ${(snameError??)?string('is-invalid','')}"
                       value="${surveyName!''}"
                       name="sname" placeholder="survey name"/>
                <#if snameError??>
                    <div class="invalid-feedback">${snameError}</div>
                </#if>
            </div>

            <div class="form-group">
                <input type="text" class="form-control ${(descriptionError??)?string('is-invalid','')}"
                       value="${surveyDescription!''}"
                       name="description" placeholder="description"/>
                <#if descriptionError??>
                    <div class="invalid-feedback">${descriptionError}</div>
                </#if>
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-primary ml-2">${button}</button>
            </div>
        </form>
    </div>
</#macro>