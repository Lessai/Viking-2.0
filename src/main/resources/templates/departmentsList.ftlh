<#import "parts/common.ftlh" as c>
<#import "parts/autocompleteFunction.ftlh" as a>

<@c.page>
    <div class="addForm mx-3 p-5 mb-3">
        <a class="text-info" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            <i class="fas fa-plus"></i>  Добавить подразделение
        </a>
        <br>
        <div class="collapse" id="collapseExample">
            <div class="form-group mt-3">
                <form autocomplete="off" method="post" enctype="multipart/form-data" action="/HR/addDepartment">
                    <div class="form-group">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    </div>
                    <div class="row">
                        <div class="form-group col">
                            <input type="text" name = "departmentCode" class="form-control" placeholder="Код отдела">
                        </div>
                        <div class="form-group col">
                            <input type="text" name = "departmentName" class="form-control" placeholder="Название отдела">
                        </div>
                    </div>
                    <div class="row">
                        <div class="autocomplete form-group col">
                            <input id="myManagerInput" type="text" name = "managerName" class="form-control" placeholder="Менеджер">
                        </div>
                        <div class="form-group col">
                            <input id="myAddressInput" type="text" name = "departmentAddress" class="form-control" placeholder="Страна, г. Город, ул. Улица, Здание">
                        </div>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-warning">Сохранить отдел</button>
                    </div>
                </form>
            </div>
        </div>
        <br>
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
                    <td>${department.departmentManager.personFirstName} ${department.departmentManager.personLastName}</td>
                    <td>
                        <#if department.address??>
                        ${(department.address.street.city.localRegion.country.countryName)!},
                         ${(department.address.street.city.atdType.atdTypeSName)!}
                        ${(department.address.street.city.cityName)!},
                         ${(department.address.street.atdType.atdTypeSName)!}
                        ${(department.address.street.streetName)!},
                         ${(department.address.building)!}
                        </#if>
                    </td>
                    <td><a href="#">Изменить</a></td>
                </tr>
            <#else>
                Нет отделов
            </#list>
            </tbody>
        </table>
    </div>

    <@a.autocomplete>
        var employeeNamesFromModel = [<#list employees as employee>"${employee.personFirstName} ${employee.personLastName}", </#list>];
        console.log(employeeNamesFromModel);
        autocomplete(document.getElementById("myManagerInput"), employeeNamesFromModel);
    </@a.autocomplete>

</@c.page>