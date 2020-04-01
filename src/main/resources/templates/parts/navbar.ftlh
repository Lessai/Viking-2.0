<#include "security.ftlh">
<#import "login.ftlh" as l>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="/">
        <img src="../img/Logo.png" width="35" height="35" class="d-inline-block align-top" alt="">
        Viking
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <#if isHR || isAdmin>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="hrDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-users"></i> Отдел кадров</a>
                    <div class="dropdown-menu" aria-labelledby="hrDropdown">
                        <a class="dropdown-item" href="/HR/employees"><i class="fas fa-users"></i> Сотрудники</a>
                        <a class="dropdown-item" href="/HR/departments"><i class="far fa-building"></i> Подразделения</a>
                        <a class="dropdown-item" href="/HR/updateAddress"><i class="fas fa-globe"></i> Адреса</a>
                    </div>
                </li>
            </#if>
            <#if isAdmin>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="adminDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user-graduate"></i> Администратор</a>
                    <div class="dropdown-menu" aria-labelledby="adminDropdown">
                        <a class="dropdown-item" href="/admin"><i class="fas fa-user-check"></i> Список пользователей</a>
                    </div>
                </li>
            </#if>
            <#if user??>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="trainingDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-graduation-cap"></i> Тренинги</a>
                    <div class="dropdown-menu" aria-labelledby="trainingDropdown">
                        <a class="dropdown-item" href="/trainings">Все тренинги</a>
                        <a class="dropdown-item" href="/trainings/myTrainings">Мои тренинги</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user/profile"><i class="fas fa-user-alt"></i> Профиль</a>
                </li>
            </#if>
        </ul>
        <div class="navbar-text mr-3">${name}</div>
        <#if user??>
            <@l.logout />
        </#if>
        <#if !user??>
            <@l.loginBtn />
        </#if>
    </div>
</nav>