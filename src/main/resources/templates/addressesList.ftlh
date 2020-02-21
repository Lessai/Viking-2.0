<#import "parts/common.ftlh" as c>
<@c.page>
    <div>
        <img src="../img/Minsk.png" width="300" height="100" class="d-inline-block align-top" alt="">
    </div>
    <!------------------------- REGION ------------------------------>
    <div class="addForm mx-3 p-5 mb-3">
        <a class="text-info" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            <i class="fas fa-plus"></i>  Добавить регион
        </a>
        <br>
        <div class="collapse" id="collapseExample">
            <div class="form-group mt-3">
                <form method="post"  action="/admin/updateRegion" enctype="multipart/form-data">
                    <div class="form-group">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    </div>
                    <H4>Регион</H4>
                    <div class="form-group">
                        <input type="text" name = "regionName" class="form-control" placeholder="Регион">
                    </div>
                    <hr>
                    <div class="form-group">
                        <button type="submit"  class="btn btn-outline-warning">Сохранить регион</button>
                    </div>
                </form>
            </div>
        </div>
        <br>
        <H4>Список регионов</H4>
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Название</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <#list regions as region>
                <tr>
                    <td>${region.regionID!"--"}</td>
                    <td>${region.regionName!"--"}</td>
                    <td><a class="text-info" href="#">Изменить</a></td>
                </tr>
            <#else>
                Нет регионов
            </#list>
            </tbody>
        </table>
    </div>

    <!------------------------- ATD ------------------------------>
    <div class="addForm mx-3 p-5 mb-3">
        <a class="text-info" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            <i class="fas fa-plus"></i>  Добавить АТД
        </a>
        <br>
        <div class="collapse" id="collapseExample">
            <div class="form-group mt-3">
                <form method="post" action="/admin/updateAtd" enctype="multipart/form-data">
                    <div class="form-group">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    </div>
                    <H4>АТД</H4>
                    <div class="form-group">
                        <input type="text" name = "atdTypeName" class="form-control" placeholder="Название АТД">
                    </div>
                    <div class="form-group">
                        <input type="text" name = "atdTypeSName" class="form-control" placeholder="Сокращение АТД">
                    </div>
                    <hr>
                    <div class="form-group">
                        <button type="submit" class="btn btn-outline-warning">Сохранить АТД</button>
                    </div>
                </form>
            </div>
        </div>
        <br>
        <H4>Список АТД</H4>
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Название</th>
                <th scope="col">Сокращение</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <#list atdTypes as atdType>
                <tr>
                    <td>${atdType.atdTypeID!"--"}</td>
                    <td>${atdType.atdTypeName!"--"}</td>
                    <td>${atdType.atdTypeSName!"--"}</td>
                    <td><a class="text-info"href="#">Изменить</a></td>
                </tr>
            <#else>
                Нет Административно-территориальных делений
            </#list>
            </tbody>
        </table>
    </div>

    <!------------------------- COUNTRY ------------------------------>
    <div class="addForm mx-3 p-5 mb-3">
        <a class="text-info" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            <i class="fas fa-plus"></i>  Добавить Страну
        </a>
        <br>
        <div class="collapse" id="collapseExample">
            <div class="form-group mt-3">
                <form method="post" action="/admin/updateCountry" enctype="multipart/form-data">
                    <div class="form-group">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    </div>
                    <H4>Страна</H4>
                    <div class="row">
                        <div class="form-group col">
                            <input type="text" name = "countryCode" class="form-control" placeholder="Код страны">
                        </div>
                        <div class="form-group col">
                            <input type="text" name = "countryName" class="form-control" placeholder="Страна">
                        </div>
                        <div class="form-group col">
                            <select id = "regions" name = "regionName"  class="form-control">
                                <#list regions as region>
                                    <option value = "${region.regionName}">${region.regionName}</option>
                                <#else>
                                    Нет регионов
                                </#list>
                            </select>
                        </div>
                    </div>
                    <hr>
                    <div class="form-group">
                        <button type="submit" class="btn btn-outline-warning">Сохранить Страну</button>
                    </div>
                </form>
            </div>
        </div>
        <br>
        <H4>Список Стран</H4>
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Код страны</th>
                <th scope="col">Страна</th>
                <th scope="col">Регион</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <#list countries as country>
                <tr>
                    <td>${country.countryID!"--"}</td>
                    <td>${country.countryCode!"--"}</td>
                    <td>${country.countryName!"--"}</td>
                    <td>${country.region.regionName!"--"}</td>
                    <td><a class="text-info"href="#">Изменить</a></td>
                </tr>
            <#else>
                Нет стран
            </#list>
            </tbody>
        </table>
    </div>

</@c.page>