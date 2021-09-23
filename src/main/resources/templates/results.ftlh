<#import "includes/common.ftlh" as p>

<@p.page>
    <#if author.authorname=='default user'>
        <strong>for anonymous user with id ${author.id}</strong>
    <#else>
        Employee: <strong>${author.authorname}</strong>
    </#if>
    <#if (authorAnswer)??>
        <table class="results-table">
            <tr class="result-headers">
                <th class="question">Question#</th>
                <th class="employee-answer">Employee answer</th>
                <th class="answer">Right Answer</th>
                <th class="checked">Checked</th>
            </tr>
            <#list authorAnswer as answer>
                <tr class="result-answers">
                    <td>${answer.questionId}</td>
                    <td>${answer.author_answer}</td>
                    <td>${answer.right_answer}</td>
                    <td>${answer.isChecked()?then('correct','not correct')}</td>
                </tr>
            </#list>
        </table>
    <#else>
        no results available, please start survey again!
    </#if>
    <br/>
    <div>
        <a href="/surveyApp/surveys/${author.id}">
            <span>Try survey again?</span>
        </a>
    </div>
</@p.page>