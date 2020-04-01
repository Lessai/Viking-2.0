<#import "parts/common.ftlh" as c>
<#import "parts/autocompleteFunction.ftlh" as a>
<@c.page>
    <script type="text/javascript">
        function toggle(id){
            var div = ['region', 'atd', 'country', 'city', 'street'];
            var e = document.getElementById(id);
            for (index = 0; index < div.length; index++) {
                if (id != div[index]) {
                    var e2 = document.getElementById(div[index]);
                    e2.style.display = 'none';
                }else{
                    if (e.style.display == '') {
                        e.style.display = 'none';
                    }
                    else{
                        e.style.display = '';
                    }
                }
            }
        }
    </script>

    <div class="row mx-1">
        <div class="col addForm mx-3 mb-3" onclick="toggle('region')">
            <div class="mx-collapce py-3">
                <p>Регион</p>
                <img src="../img/region.png"  width="100" height="100" class=" top-img d-inline-block align-top" alt="">
            </div>
        </div>
        <div class="col addForm mx-3 mb-3" onclick="toggle('country')">
            <div class="mx-collapce py-3">
                <p>Страна</p>
                <img src="../img/country.png"  width="100" height="100" class=" top-img d-inline-block align-top" alt="">
            </div>
        </div>
        <div class="col addForm mx-3 mb-3" onclick="toggle('city')">
            <div class="mx-collapce py-3">
                <p>Город</p>
                <img src="../img/city.png"  width="100" height="100" class=" top-img d-inline-block align-top" alt="">
            </div>
        </div>
        <div class="col addForm mx-3 mb-3" onclick="toggle('street')">
            <div class="mx-collapce py-3">
                <p>Улица</p>
                <img src="../img/location1.png"  width="100" height="100" class=" top-img d-inline-block align-top" alt="">
            </div>
        </div>
        <div class="col addForm mx-3 mb-3" onclick="toggle('atd')">
            <div class="mx-collapce py-3">
                <p>АТД</p>
                <img src="../img/village.png"  width="100" height="100" class=" top-img d-inline-block align-top" alt="">
            </div>
        </div>
    </div>
    <!------------------------- REGION ------------------------------>
    <div class="addForm mx-3 p-5 mb-3" style="display: none" id="region">
        <a class="text-info" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            <i class="fas fa-plus"></i>  Добавить Регион
        </a>
        <br>
        <div class="collapse" id="collapseExample">
            <div class="form-group mt-3">
                <form method="post"  action="/HR/addRegion" enctype="multipart/form-data">
                    <div class="form-group">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    </div>
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
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Регион</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <#list regions as region>
                <tr>
                    <td>${region?counter}</td>
                    <td>${region.regionName!"--"}</td>
                    <td><a class="text-info" href="#">Изменить</a></td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>

    <!------------------------- ATD ------------------------------>
    <div class="addForm mx-3 p-5 mb-3" style="display: none" id="atd">
        <a class="text-info" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            <i class="fas fa-plus"></i>  Добавить АТД
        </a>
        <br>
        <div class="collapse" id="collapseExample">
            <div class="form-group mt-3">
                <form method="post" action="/HR/addAtd" enctype="multipart/form-data">
                    <div class="form-group">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    </div>
                    <div class="row">
                        <div class="form-group col">
                            <input type="text" name = "atdTypeName" class="form-control" placeholder="Название АТД">
                        </div>
                        <div class="form-group col">
                            <input type="text" name = "atdTypeSName" class="form-control" placeholder="Сокращение АТД">
                        </div>
                    </div>
                        <hr>
                        <div class="form-group">
                            <button type="submit" class="btn btn-outline-warning">Сохранить АТД</button>
                        </div>
                </form>
            </div>
        </div>
        <br>
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">АТД</th>
                <th scope="col">Сокращение</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <#list atdTypes as atdType>
                <tr>
                    <td>${atdType?counter}</td>
                    <td>${atdType.atdTypeName!"--"}</td>
                    <td>${atdType.atdTypeSName!"--"}</td>
                    <td><a class="text-info"href="#">Изменить</a></td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>

    <!------------------------- COUNTRY ------------------------------>
    <div class="addForm mx-3 p-5 mb-3" style="display: none" id="country">
        <a class="text-info" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            <i class="fas fa-plus"></i>  Добавить Страну
        </a>
        <br>
        <div class="collapse" id="collapseExample">
            <div class="form-group mt-3">
                <form method="post" action="/HR/addCountry" enctype="multipart/form-data">
                    <div class="form-group">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    </div>
                    <div class="row">
                        <div class="form-group col">
                            <input type="text" name = "countryCode" class="form-control" placeholder="Код страны">
                        </div>
                        <div class="form-group col">
                            <input type="text" name = "countryName" class="form-control" placeholder="Страна">
                        </div>
                        <div class="form-group col">
                            <select id = "regions" name = "regionName"  class="form-control">
                                <option value="" disabled selected>Регион</option>
                                <#list regions as region>
                                    <option value = "${region.regionName}">${region.regionName}</option>
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
                    <td>${country?counter}</td>
                    <td>${country.countryCode!"--"}</td>
                    <td>${country.countryName!"--"}</td>
                    <td>${country.region.regionName!"--"}</td>
                    <td><a class="text-info"href="#">Изменить</a></td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
    <!------------------------- City ------------------------------>
    <div class="addForm mx-3 p-5 mb-3" style="display: none" id="city">
        <a class="text-info" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            <i class="fas fa-plus"></i>  Добавить Город
        </a>
        <br>
        <div class="collapse" id="collapseExample">
            <div class="form-group mt-3">
                <form method="post" action="/HR/addCity" enctype="multipart/form-data">
                    <div class="form-group">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    </div>
                    <div class="row">
                        <div class="form-group col">
                            <input type="text" name = "cityCode" class="form-control" placeholder="Код города">
                        </div>
                        <div class="form-group col">
                            <input type="text" name = "cityName" class="form-control" placeholder="Город">
                        </div>
                        <div class="form-group col">
                            <select id = "atdType" name = "atdTypeName"  class="form-control">
                                <option value="" disabled selected>АТД</option>
                                <#list atdTypes as atdType>
                                    <option value = "${atdType.atdTypeName}">${atdType.atdTypeName}</option>
                                </#list>
                            </select>
                        </div>
                        <div class="form-group col">
                            <select id = "localRegion" name = "localRegionName"  class="form-control">
                                <option value="" disabled selected>Локальный Регион</option>
                                <#list localRegions as localRegion>
                                    <option value = "${localRegion.localRegionName}">${localRegion.localRegionName}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <hr>
                    <div class="form-group">
                        <button type="submit" class="btn btn-outline-warning">Сохранить Город</button>
                    </div>
                </form>
            </div>
        </div>
        <br>
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Код города</th>
                <th scope="col">Город</th>
                <th scope="col">АТД</th>
                <th scope="col">Локальный регион</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <#list cities as city>
                <tr>
                    <td>${city?counter}</td>
                    <td>${city.cityCode!"--"}</td>
                    <td>${city.cityName!"--"}</td>
                    <td>${city.atdType.atdTypeName!"--"}</td>
                    <td>${city.localRegion.localRegionName!"--"}</td>
                    <td><a class="text-info"href="#">Изменить</a></td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
    <!------------------------- Street ------------------------------>
    <div class="addForm mx-3 p-5 mb-3" style="display: none" id="street">
        <a class="text-info" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            <i class="fas fa-plus"></i>  Добавить Улицу
        </a>
        <br>
        <div class="collapse" id="collapseExample">
            <div class="form-group mt-3">
                <form autocomplete="off" method="post" action="/HR/addStreet" enctype="multipart/form-data">
                    <div class="form-group">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    </div>
                    <div class="row">
                        <div class="autocomplete form-group col">
                            <input id="myStreetInput" type="text" name = "streetName" class="form-control" placeholder="Улица">
                        </div>
                        <div class="form-group col">
                            <select name = "atdTypeName"  class="form-control">
                                <option value="" disabled selected>АТД</option>
                                <#list atdTypes as atdType>
                                    <option value = "${atdType.atdTypeName}">${atdType.atdTypeName}</option>
                                </#list>
                            </select>
                        </div>
                        <div class="form-group col">
                            <select id = "city" name = "cityName"  class="form-control">
                                <option value="" disabled selected>Город</option>
                                <#list cities as city>
                                    <option value = "${city.cityName}">${city.cityName}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <hr>
                    <div class="form-group">
                        <button type="submit" class="btn btn-outline-warning">Сохранить Улицу</button>
                    </div>
                </form>
            </div>
        </div>
        <br>
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Улица</th>
                <th scope="col">АТД</th>
                <th scope="col">Город</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <#list streets as street>
                <tr>
                    <td>${street?counter}</td>
                    <td>${street.streetName!"--"}</td>
                    <td>${street.atdType.atdTypeName!"--"}</td>
                    <td>${street.city.cityName!"--"}</td>
                    <td><a class="text-info" href="#">Изменить</a></td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>

    <@a.autocomplete>
        /*An array containing all the country names in the world:*/
        var streetNamesFromModel = [<#list streetsName as name>"${name}",</#list>];
        /*initiate the autocomplete function on the "myInput" element, and pass along the countries array as possible autocomplete values:*/
        autocomplete(document.getElementById("myStreetInput"), streetNamesFromModel);
    </@a.autocomplete>

</@c.page>