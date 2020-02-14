<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="addForm">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </div>
            <H4>Отдел</H4>
            <div class="form-group">
                <input type="text" name = "departmentCode" class="form-control" placeholder="Код отдела">
                <#if tagError??>
                    <div class="invalid-feedback">
                        ${codeError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" name = "departmentName" class="form-control" placeholder="Название отдела">
                <#if tagError??>
                    <div class="invalid-feedback">
                        ${nameError}
                    </div>
                </#if>
            </div>
            <hr>
            <H4>Начальник отдела</H4>
            <div>Тут должен быть поиск начальниака по его ФИО</div>
            <hr>
            <H4>Адрес</H4>
            <div>Тут должен быть поиск адреса</div>
            <br>
            <div class="form-group">
                <button type="submit" class="btn btn-warning">Сохранить отдел</button>
            </div>
        </form>
    </div>
</@c.page>