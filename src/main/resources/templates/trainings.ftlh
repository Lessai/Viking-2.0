<#import "parts/common.ftlh" as c>

<@c.page>
    <!-- Search -->
    <form class="form-inline" method="get" action="/trainings">
        <div class="input-group mb-3">
            <input type="text" class="form-control" name="skillFilter" value="${skillFilter!}" placeholder="Поиск по навыку" aria-label="Поиск по навыку" aria-describedby="basic-addon2">
            <div class="input-group-append">
                <button type="submit" class="btn btn-info" id="basic-addon2"><i class="fas fa-search"></i></button>
            </div>
        </div>
    </form>
    <#if myTrainings>
        <!-- My trainings -->
        <#include "parts/myTrainingList.ftlh"/>
    <#else>
        <!-- All trainings -->
        <#include "parts/trainingsList.ftlh"/>
    </#if>

</@c.page>