<#include "security.ftlh">
<#import "pager.ftlh" as p>


<@p.pager url page />
<div class="card-columns">
    <#list page.content as training>
        <div class="card border-info text-white bg-dark my-3">
            <p class="text-center mt-1 font-weight-bold">${training.trainingName}</p>
            <#if training.picturePath??>
                <img src="../img/${training.picturePath}" class="card-img-top pl-4 pr-4 pb-2">
            </#if>
            <div class="m-2">
                <div class="container">
                    <div class="row justify-content-between">
                        <i class="text-warning col-6">Навык: ${training.trainingSkill}</i>
                        <a class="col-4 text-warning" href="/trainings/${training.trainingID}/register">
                            <#if training.finished>
                                <input type="button" class="btn btn-info" disabled value="Пройден"></input>
                            <#elseif training.meRegistred>
                                <input type="button" class="btn btn-warning" value="Отменить"></input>
                            <#else>
                                <input type="button" class="btn btn-outline-warning" value="Регистрация"></input>
                            </#if>
                        </a>
                    </div>
                </div>
                <div class="row mt-2 justify-content-between">
                    <div class="col ml-2">
                        <p>Понравился тренинг?</p>
                    </div>
                    <div class="col-4">
                        <a class="text-warning align-self-center" href="/trainings/${training.trainingID}/1/rate">
                            <#if (training.myScore!0) gt 0 >
                                <i class="fas fa-star"></i>
                            <#else>
                                <i class="far fa-star"></i>
                            </#if>
                        </a>
                        <a class="text-warning align-self-center" href="/trainings/${training.trainingID}/2/rate">
                            <#if (training.myScore!0) gt 1>
                                <i class="fas fa-star"></i>
                            <#else>
                                <i class="far fa-star"></i>
                            </#if>
                        </a>
                        <a class="text-warning align-self-center" href="/trainings/${training.trainingID}/3/rate">
                            <#if (training.myScore!0) gt 2>
                                <i class="fas fa-star"></i>
                            <#else>
                                <i class="far fa-star"></i>
                            </#if>
                        </a>
                        <a class="text-warning align-self-center" href="/trainings/${training.trainingID}/4/rate">
                            <#if (training.myScore!0) gt 3>
                                <i class="fas fa-star"></i>
                            <#else>
                                <i class="far fa-star"></i>
                            </#if>
                        </a>
                        <a class="text-warning align-self-center" href="/trainings/${training.trainingID}/5/rate">
                            <#if (training.myScore!0) gt 4>
                                <i class="fas fa-star"></i>
                            <#else>
                                <i class="far fa-star"></i>
                            </#if>
                        </a>
                    </div>
                </div>
                <div>
                    <a class="text-info ml-2" data-toggle="collapse" href="#collapseDesc#{training.trainingID}" aria-expanded="false" aria-controls="collapseExample">
                        Посмотреть описание
                    </a>
                    <div class="collapse" id="collapseDesc#{training.trainingID}">
                        <span>${training.trainingDesc}</span>
                    </div>
                </div>
                <div>
                    <a class="text-info ml-2" data-toggle="collapse" href="#collapseInfo#{training.trainingID}" aria-expanded="false" aria-controls="collapseExample">
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
