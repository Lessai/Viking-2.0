<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="row justify-content-center">
        <#if notificationMessage?starts_with("Сотрудник")>
            <div class="alert alert-success col-5 p-5" role="alert">
                <i class="far fa-smile-beam fa-3x"></i>
                <br>
                ${notificationMessage}
                <br>
                <a href="/HR/employees" class="text-success font-weight-normal">Вернуться на страницу с сотрудниками</a>
            </div>
        <#else>
            <div class="alert alert-danger col-5 p-5" role="alert">
                <i class="far fa-sad-tear fa-3x"></i>
                <br>
                ${notificationMessage}
                <br>
                <a href="/HR/employees" class="text-success font-weight-normal">Вернуться на страницу с сотрудниками</a>
            </div>
        </#if>
    </div>

</@c.page>