<#import "security.ftlh" as security>
<#import "loginMacro.ftlh" as lm>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="navbar-text mr-2">Survey application</div>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
                <a class="nav-link" aria-current="page" href="/">Home</a>
            </li>
        </ul>
        <#if security.admin??>
            <ul class="navbar-nav me-6 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/admin">Admin Page</a>
                </li>
            </ul>
            <div class="navbar-text mr-2">
                ${security.username}
            </div>
            <@lm.logout />
        <#else>
            <a class="btn btn-primary mb-2" href="/auth/login">Admin Login</a>
        </#if>
    </div>
</nav>