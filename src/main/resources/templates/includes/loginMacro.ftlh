
<#macro login path>
    <form action="${path}" method="get">
<#--        <input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
        <div class="mb-3 row">
            <label for="inputPassword" class="col-sm-2 col-form-label">Admin name</label>
            <div class="col-sm-6">
                <input type="text" class="form-control ${(usernameError??)?string('is-invalid','')}"
                       name="username" placeholder="username"/>
                <#if usernameError??>
                    <div class="invalid-feedback">${usernameError}</div>
                </#if>
            </div>
        </div>
        <div class="mb-3 row">
            <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-6">
                <input type="text" class="form-control ${(passwordError??)?string('is-invalid','')}"
                       name="password" placeholder="password"/>
                <#if passwordError??>
                    <div class="invalid-feedback">${passwordError}</div>
                </#if>
            </div>
        </div>
        <div class="col-auto">
            <button type="submit" class="btn btn-primary mb-3">Sign in</button>
        </div>
    </form>
</#macro>