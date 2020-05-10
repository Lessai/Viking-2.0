<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="addForm mx-3 p-5 mb-3">
        <div class="form-group mt-3">
            <form method="post" action="/HR/dismissEmployee" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                </div>
                <div class="form-group row justify-content-center">
                    <i class="fas fa-user-times fa-3x" style="color: #747474"></i>
                </div>
                <div class="container form-bordered pt-3">
                    <div class="row justify-content-between">
                        <div class="form-group col">
                            <label><i class="far fa-address-card"></i> Табельный номер:</label>
                            <input type="text" value="${employee.personTabN}" readonly="readonly" name = "tabN" class="form-control" placeholder="Таб номер">
                            <input type="text" value="${employee.personTabN}" hidden name = "tabNHidden" class="form-control">
                        </div>
                        <div class="form-group col">
                            <label>Имя:</label>
                            <input required type="text" name = "firstName" disabled class="form-control" value="${employee.personFirstName}">
                        </div>
                    </div>
                    <div class="row justify-content-between">
                        <div class="col" >
                            <label for="dateIn">Дата увольнения:</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="basic-addon1"><i class="far fa-calendar-alt"></i></span>
                                </div>
                                <input required  type="date" id="dateOut" class="form-control" name="dateOut"
                                       min="2010-01-01" max="2030-01-01" aria-describedby="basic-addon1">
                            </div>
                        </div>
                        <div class="form-group col">
                            <label>Фамилия:</label>
                            <input required type="text" name = "secondName" disabled class="form-control" value="${employee.personLastName}">
                        </div>
                    </div>
                    <div  class="row justify-content-between">
                        <div class="form-group col-12">
                            <label for="textarea1">Причина увольнения: </label>
                            <textarea class="form-control" id="textarea1" name="dismissionReason"
                                      placeholder="Введите причину увольнения" rows="3"></textarea>
                        </div>
                    </div>
                    <div  class="row justify-content-between">
                        <div class="form-group col-6">
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" name="isOrder" id="customCheck2">
                                <label class="custom-control-label" for="customCheck1">Сформировать приказ</label>
                            </div>
                        </div>
                        <div class="form-group col-auto">
                            <button type="submit" class="btn btn-outline-warning"><i class="far fa-save"></i> Сохранить</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</@c.page>