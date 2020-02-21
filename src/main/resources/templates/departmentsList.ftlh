<#import "parts/common.ftlh" as c>

<@c.page>

    <div class="addForm mx-3 p-5 mb-3">
        <a class="btn btn-warning" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            Добавить отдел
        </a>
        <br>
        <div class="collapse" id="collapseExample">
            <div class="form-group mt-3">
                <form method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    </div>
                    <H4>Отдел</H4>
                    <div class="form-group">
                        <input type="text" name = "departmentCode" class="form-control" placeholder="Код отдела">
                    </div>
                    <div class="form-group">
                        <input type="text" name = "departmentName" class="form-control" placeholder="Название отдела">
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
        </div>
        <br>
        <H3>Список отделов</H3>
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Код</th>
                <th scope="col">Название</th>
                <th scope="col">Начальник</th>
                <th scope="col">Адрес</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <#list departments as department>
                <tr>
                    <td>${department.departmentId!"--"}</td>
                    <td>${department.departmentCode!"--"}</td>
                    <td>${department.departmentName!"--"}</td>
                    <td>ФИО манагера</td>
                    <td>Адрес</td>
                    <td><a href="#">Изменить</a></td>
                </tr>
            <#else>
                Нет отделов
            </#list>
            </tbody>
        </table>
    </div>
</@c.page>