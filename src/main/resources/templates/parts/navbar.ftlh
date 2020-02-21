<#include "security.ftlh">
<#import "login.ftlh" as l>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/">
        <img src="../img/Logo.png" width="35" height="35" class="d-inline-block align-top" alt="">
        Viking
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Главная</a>
            </li>
            <#if isHR || isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/HR/employees"><i class="fas fa-users"></i> Сотрудники</a>
                </li>
            </#if>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/admin"><i class="fas fa-user-check"></i> Пользователи</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user-secret"></i> Администратор</a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/admin/updateDepartment"><i class="far fa-building"></i> Подразделения</a>
                        <a class="dropdown-item" href="/admin/updateAddress"><i class="fas fa-globe"></i> Адреса</a>
                    </div>
                </li>
            </#if>
            <#if user??>
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