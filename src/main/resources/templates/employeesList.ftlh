<#import "parts/common.ftlh" as c>
<#import "parts/autocompleteFunction.ftlh" as a>

<@c.page>
    <div class="addForm mx-3 p-5 mb-3">
        <a class="text-info" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            <i class="fas fa-plus"></i>  Добавить сотрудника
        </a>
        <br>
        <div class="collapse" id="collapseExample">
            <div class="form-group mt-3">
                <form method="post" action="/HR/addEmployee" enctype="multipart/form-data">
                    <div class="form-group">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    </div>
                    <div class="form-group row justify-content-center">
                        <i class="far fa-user-circle fa-3x" style="color: #747474"></i>
                    </div>
                    <div class="container form-bordered pt-3">
                        <div class="row justify-content-between">
                            <div class="form-group col">
                                <label><i class="far fa-address-card"></i> Табельный номер:</label>
                                <input type="text" value="${tabN}" readonly="readonly" name = "tabN" class="form-control" placeholder="Таб номер">
                            </div>
                            <div class="form-group col">
                                <label for = "department">Данные о вакансии:</label>
                                <select required id = "department" name = "department"  class="form-control">
                                    <#list departments as department>
                                        <option value = "${department.departmentName}">${department.departmentName}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                        <div class="row justify-content-between">
                            <div class="col" >
                                <label for="dateIn">Дата приема на работу:</label>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="basic-addon1"><i class="far fa-calendar-alt"></i></span>
                                    </div>
                                    <input required  type="date" id="dateIn" class="form-control" name="dateIn"
                                           min="2010-01-01" max="2030-01-01" aria-describedby="basic-addon1">
                                </div>
                            </div>
                            <div class="form-group col">
                                <label for="category">Категория:</label>
                                <select required  id = "category" name = "categoryName"  class="form-control">
                                    <#list categories as category>
                                        <option value = "${category.categName}">${category.categName}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                        <div class="row justify-content-between">
                            <div class="form-group col">
                                <label>Персональные данные:</label>
                                <input required type="text" name = "firstName" class="form-control" placeholder="Имя">
                            </div>
                            <div class="form-group col">
                                <label for="title">Должность:</label>
                                <select required id = "title" name = "title"  class="form-control">
                                    <#list titles as title>
                                        <option value = "${title.titleName}">${title.titleName}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                        <div class="row justify-content-between">
                            <div class="form-group col">
                                <input required type="text" name = "secondName" class="form-control" placeholder="Фамилия">
                            </div>
                            <div class="form-group col">
                                <select id = "workMode" name = "workMode"  class="form-control">
                                    <option value="" disabled selected>Режим работы</option>
                                    <#list workmodes as workmode>
                                        <option value = "${workmode.workModeName}">${workmode.workModeName}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                        <div class="row justify-content-start">
                            <div class="col-4" >
                                <label for="birthDate">Дата рождения:</label>
                                <div class="input-group mb-3 ">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="basic-addon1"><i class="far fa-calendar-alt"></i></span>
                                    </div>
                                    <input required type="date" id="birthDate" class="form-control" name="birthDate"
                                           min="1950-01-01" max="2030-01-01" aria-describedby="basic-addon1">
                                </div>
                            </div>
                            <div class="form-group col-2">
                                <label for="gender">Пол</label>
                                <select id = "gender" name = "gender"  class="form-control">
                                    <option value="" disabled selected>Пол</option>
                                    <#list genders as gender>
                                        <option value = "${gender.genderName}">${gender.genderName}</option>
                                    </#list>
                                </select>
                            </div>
                            <div class="form-group col-3">
                                <div class="custom-control custom-checkbox">
                                    <input type="checkbox" class="custom-control-input" name="isContract" id="customCheck1">
                                    <label class="custom-control-label" for="customCheck1">Сформировать договор</label>
                                </div>
                            </div>
                            <div class="form-group col-3">
                                <div class="custom-control custom-checkbox">
                                    <input type="checkbox" class="custom-control-input" name="isOrder" id="customCheck2">
                                    <label class="custom-control-label" for="customCheck1">Сформировать приказ</label>
                                </div>
                            </div>
                        </div>
                        <div  class="row justify-content-between">
                            <div class="form-group col-6">
                                <label for="maritalStatus">Семейное положение</label>
                                <select id = "maritalStatus" name = "maritalStatus"  class="form-control">
                                    <#list maritalstatuses as maritalStatus>
                                        <option value = "${maritalStatus.maritalStatusName}">${maritalStatus.maritalStatusName}</option>
                                    </#list>
                                </select>
                            </div>
                            <div class="form-group col-auto">
                                <button type="submit" class="btn btn-outline-warning"><i class="far fa-save"></i> Сохранить</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <br>

        <!------------------------------------------------ Filtering ------------------------------------------------->


        <form class="form-inline" method="get" action="/HR/employees">
            <div class="form-row mb-3 justify-content-between">
                <div class="form-group col-md-4 col-xs-4" style="margin-right: -10px">
                    <label for = "departmentFilter">Подразделение:</label>
                    <select id = "departmentFilter" name = "departmentFilter"  class="form-control">
                        <option value="Все" selected>Все</option>
                        <#list departments as department>
                            <option value = "${department.departmentName}">${department.departmentName}</option>
                        </#list>
                    </select>
                </div>
                <div class="form-group col-3" style="margin-right: -50px">
                    <label for = "categoryFilter">Категория:</label>
                    <select id = "categoryFilter" name = "categoryFilter"  class="form-control">
                        <option value="Все" selected>Все</option>
                        <#list categories as category>
                            <option value = "${category.categName}">${category.categName}</option>
                        </#list>
                    </select>
                </div>
                <div class="form-group col-2">
                    <label for = "filterFirstName">Имя:</label>
                    <input type="text" name = "filterFirstName" class="form-control" value="Имя" >
                </div>
                <div class="form-group col-2">
                    <label for = "filterLastName">Фамилия:</label>
                    <input type="text" name = "filterLastName" class="form-control" value="Фамилия" >
                </div>
                <div class="col-1 mt-4">
                    <button type="submit" class="btn btn-info" id="basic-addon2"><i class="fas fa-search"></i></button>
                </div>
            </div>
        </form>

        <!-------------------------------------------------- TABLE ------------------------------------------------->
        <div class="table-responsive">
            <table class="table table-sm table-bordered">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Изме- нить</th>
                    <th scope="col">Уво- лить</th>
                    <th scope="col">Таб. №</th>
                    <th scope="col">Имя</th>
                    <th scope="col">Фамилия</th>
                    <th scope="col">Дата приема</th>
                    <th scope="col">Дата увольнения</th>
                    <th scope="col">Дата рождения</th>
                    <th scope="col">Пол</th>
                    <th scope="col">Семейное положение</th>
                    <th scope="col">Должность</th>
                    <th scope="col">Категория</th>
                    <th scope="col">Подразделение</th>
                    <th scope="col">Режим работы</th>

                </tr>
                </thead>
                <tbody>
                <#list employees as employee>
                    <tr>
                        <td>${employee?counter}</td>
                        <td><a class="text-info" href="/HR/employees/${employee.personTabN}/edit"><i class="fas fa-pencil-alt text-info"></i></a></td>
                        <td><a class="text-danger" href="/HR/employees/${employee.personTabN}/dismiss"><i class="fas fa-user-times"></i></a></td>
                        <td>${employee.personTabN!"--"}</td>
                        <td>${employee.personFirstName!"--"}</td>
                        <td>${employee.personLastName!"--"}</td>
                        <td>${employee.personDateIN?date!"--"}</td>
                        <td><#if employee.personDateOut??> ${employee.personDateOut?date}
                            <#else> --
                            </#if>
                        </td>
                        <td>${employee.personBirthDate?date!"--"}</td>
                        <td>${employee.gender.genderCode!"--"}</td>
                        <td>${employee.maritalStatus.maritalStatusName!"--"}</td>
                        <td>${employee.title.titleName!"--"}</td>
                        <td>${employee.category.categName!"--"}</td>
                        <td>${employee.department.departmentName!"--"}</td>
                        <td>${employee.workMode.workModeName!"--"}</td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>


</@c.page>