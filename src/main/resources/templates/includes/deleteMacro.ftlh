<#macro deleteItem  item id>
    <div class="alert alert-success col-sm-8" role="alert">
        ${item} #${id} is deleted!
    </div>
    <di>
        <a href="/surveyApp/admin">
            <span>Back to admin page</span>
        </a>
    </di>
</#macro>