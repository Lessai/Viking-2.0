<#include "security.ftlh">
<#import "pager.ftlh" as p>


<@p.pager url page />
<div class="card-columns">
    <#list page.content as training>
        <div class="card border-info text-white bg-dark my-3">
            <p class="text-center mt-1 font-weight-bold">${training.trainingName}</p>
            <#if training.picturePath??>
                <img src="../img/${training.picturePath}" class="card-img-top pl-2 pr-2 pb-2">
            </#if>
            <div class="m-2">
                <div class="container">
                    <div class="row justify-content-between">
                        <i class="text-warning col-6">Навык: ${training.trainingSkill}</i>
                        <a class="col-5 text-warning" href="/trainings/${training.trainingID}/register">
                            <#if training.meRegistred>
                                <input type="button" class="btn btn-warning" value="Отменить"></input>
                            <#else>
                                <input type="button" class="btn btn-outline-warning" value="Регистрация"></input>
                            </#if>
                        </a>
                    </div>
                </div>
                <div>
                    <a class="text-info" data-toggle="collapse" href="#collapseDesc#{training.trainingID}" aria-expanded="false" aria-controls="collapseExample">
                        Посмотреть описание
                    </a>
                    <div class="collapse" id="collapseDesc#{training.trainingID}">
                        <span>${training.trainingDesc}</span>
                    </div>
                </div>
                <div>
                    <a class="text-info" data-toggle="collapse" href="#collapseInfo#{training.trainingID}" aria-expanded="false" aria-controls="collapseExample">
                        Основная информация
                    </a>
                    <div class="collapse" id="collapseInfo#{training.trainingID}">
                        <table class="table table-dark">
                            <tbody>
                            <tr>
                                <td>Тип</td>
                                <td>${training.trainingCondType}</td>
                            </tr>
                            <tr>
                                <td>Начало</td>
                                <td>${training.trainingStartDt?date}</td>
                            </tr>
                            <tr>
                                <td>Конец</td>
                                <td>${training.trainingEndDate?date}</td>
                            </tr>
                            <tr>
                                <td>Кол-во занятий</td>
                                <td>${training.trainingNrOfSessions}</td>
                            </tr>
                            <tr>
                                <td>Цена</td>
                                <td>${training.trainingPrice} BYN</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
        </div>
    <#else>
        Нет тренингов
    </#list>
</div>
<@p.pager url page />
