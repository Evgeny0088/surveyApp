<#import "includes/common.ftlh" as p>

<@p.page>
    <h3>Welcome to survey main page</h3>
    <div>
        Please introduce yourself or just click Next,
        to pass survey anonymously
    </div>

    <div class="form-group col-sm-6">
        <form method="post">
            <div class="form-group">
                <label>
                    <input type="text" class="form-control"
                           name="authorname" placeholder="Employee name"
                    />
                </label>
            </div>
<#--            <input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
            <div class="form-group">
                <button type="submit" class="btn btn-primary ml-2">Next</button>
            </div>
        </form>
    </div>

    <div class="form-group col-sm-6">
        <form method="get">
            <div class="form-group">
                <label>
                    <input type="text" class="form-control"
                           name="author_id" placeholder="Employee id"
                    />
                </label>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary ml-2">Find passed surveys by user id</button>
            </div>
        </form>
        <#if author_id??>
            <h5>Passed surveys by user # ${author_id} </h5>
            <ul class="list-group mt-2">
                <#list passed_surveys as survey>
                    <li class="list-group-item">
                        <a href="results/${survey.id}/${author_id}">check results for ${survey.sname}</a>
                    </li>
                <#else>
                    No results
                </#list>
            </ul>
        </#if>
    </div>

</@p.page>