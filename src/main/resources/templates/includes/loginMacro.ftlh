<#import "security.ftlh" as security>

<#macro login path>
    <form action="${path}" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="mb-3 row">
            <label for="username" class="col-sm-2 col-form-label">Admin name</label>
            <div class="col-sm-6">
                <input type="text" class="form-control"
                       name="username" placeholder="username"/>
            </div>
        </div>
        <div class="mb-3 row">
            <label for="password" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-6">
                <input type="password" class="form-control"
                       name="password" placeholder="password"/>
            </div>
        </div>
        <div class="col-auto">
            <button type="submit" class="btn btn-primary mb-3">Sign in</button>
        </div>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary">Log out</button>
    </form>
</#macro>