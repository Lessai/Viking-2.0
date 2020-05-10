<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="addForm mx-3 p-5 mb-3">
        <div class="form-group mt-3">
            <form method="post" action="/HR/editEmployee" enctype="multipart/form-data">
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
                            <input type="text" value="${employee.personTabN}" readonly="readonly" name = "tabN" class="form-control" placeholder="Таб номер">
                            <input type="text" value="${employee.personTabN}" hidden name = "tabNHidden" class="form-control">
                        </div>
                        <div class="form-group col">
                            <label for = "department">Данные о вакансии:</label>
                            <select required id = "department" name = "department"  class="form-control">
                                <option selected value="${employee.department.departmentName}">${employee.department.departmentName}</option>
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
                                <input required value="${employee.personDateIN?date?string('yyyy-MM-dd')}" type="date" id="dateIn" class="form-control" name="dateIn"
                                       min="2018-01-01" max="2060-01-01" aria-describedby="basic-addon1">
                            </div>
                        </div>
                        <div class="form-group col">
                            <label for="category">Категория:</label>
                            <select required  id = "category" name = "categoryName"  class="form-control">
                                <option value="${employee.category.categName}" selected>${employee.category.categName}</option>
                                <#list categories as category>
                                    <option value = "${category.categName}">${category.categName}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <div class="row justify-content-between">
                        <div class="form-group col">
                            <label>Персональные данные:</label>
                            <input required type="text" name = "firstName" class="form-control" value="${employee.personFirstName}">
                        </div>
                        <div class="form-group col">
                            <label for="title">Должность:</label>
                            <select required id = "title" name = "title"  class="form-control">
                                <#list titles as title>
                                    <option value="${employee.title.titleName}" selected>${employee.title.titleName}</option>
                                    <option value = "${title.titleName}">${title.titleName}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <div class="row justify-content-between">
                        <div class="form-group col">
                            <input required type="text" name = "secondName" class="form-control" value="${employee.personLastName}">
                        </div>
                        <div class="form-group col">
                            <select id = "workMode" name = "workMode"  class="form-control">
                                <option value="" disabled selected>Режим работы</option>
                                <#list workmodes as workmode>
                                    <option value="${employee.workMode.workModeName}" selected>${employee.workMode.workModeName}</option>
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
                                       min="1950-01-01" max="2030-01-01" aria-describedby="basic-addon1" value="${employee.personBirthDate?date?string('yyyy-MM-dd')}">
                            </div>
                        </div>
                        <div class="form-group col-2">
                            <label for="gender">Пол</label>
                            <select id = "gender" name = "gender"  class="form-control">
                                <option value="${employee.gender.genderName}" selected>${employee.gender.genderName}</option>
                                <#list genders as gender>
                                    <option value = "${gender.genderName}">${gender.genderName}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <div  class="row justify-content-between">
                        <div class="form-group col-6">
                            <label for="maritalStatus">Семейное положение</label>
                            <select id = "maritalStatus" name = "maritalStatus"  class="form-control">
                                <#list maritalstatuses as maritalStatus>
                                    <option value="${employee.maritalStatus.maritalStatusName}" selected>${employee.maritalStatus.maritalStatusName}</option>
                                    <option value = "${maritalStatus.maritalStatusName}">${maritalStatus.maritalStatusName}</option>
                                </#list>
                            </select>
                        </div>
                        <div class="form-group col-auto">
                            <button type="submit" class="btn btn-outline-warning"><i class="far fa-save"></i> Изменить</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</@c.page>