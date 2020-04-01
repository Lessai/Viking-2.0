<#macro login path submitValue isRegistrForm >
    <form class="login loginForm pb-5 mx-auto" action="${path}" method="post">
        <img src="../img/Lake.jpg" width="100%" height="120px" style="border-radius: 25px 25px 0 0;" class="d-inline-block align-top" alt="">
        <div class="form-group row mx-5 mt-3">
            <label class="col-sm-2 col-form-label"><b> Логин: </b></label>
            <div class="col-sm-6">
                <input type="text" name="username" value="<#if user??>${user.username}</#if>"
                       class="form-control ${(usernameError??)?string('is-invalid', '')}"
                       placeholder="Пользователь"/>
                <#if usernameError??>
                    <div class="invalid-feedback">
                        ${usernameError}
                    </div>
                </#if>
            </div>
        </div>
        <div class="form-group row mx-5">
            <label class="col-sm-2 col-form-label"><b> Пароль: </b></label>
            <div class="col-sm-6">
                <input type="password" name="password"
                       class="form-control ${(passwordError??)?string('is-invalid', '')}"
                       placeholder="Пароль"/>
                <#if passwordError??>
                    <div class="invalid-feedback">
                        ${passwordError}
                    </div>
                </#if>
            </div>
        </div>
        <#if isRegistrForm>
            <div class="form-group row mx-5">
                <label class="col-sm-2 col-form-label"><b> Повторите пароль: </b></label>
                <div class="col-sm-6">
                    <input type="password" name="password2"
                           class="form-control ${(password2Error??)?string('is-invalid', '')}"
                           placeholder="Повторите пароль"/>
                    <#if password2Error??>
                        <div class="invalid-feedback">
                            ${password2Error}
                        </div>
                    </#if>
                </div>
            </div>
            <div class="form-group row mx-5">
                <label class="col-sm-2 col-form-label"><b>Email: </b></label>
                <div class="col-sm-6">
                    <input type="email" value="<#if user??>${user.email}</#if>"
                           class="form-control ${(emailError??)?string('is-invalid', '')}"
                           name="email" placeholder="some@some.com"/>
                    <#if emailError??>
                        <div class="invalid-feedback">
                            ${emailError}
                        </div>
                    </#if>
                </div>
            </div>
            <div class="col-sm-6 mx-5">
                <div class="g-recaptcha" data-sitekey="6LfX6M8UAAAAALJpzzQwOZHNqJ9sFzUl11TICKAA"></div>
                <#if captchaError??>
                    <div class="alert alert-danger" role="alert">
                        ${captchaError}
                    </div>
                </#if>
            </div>
        </#if>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-warning mx-5">${submitValue}</button>
        <#if !isRegistrForm>
            <div class="mt-1 mx-5"><a class="text-info" href="/registration"><b>Создать аккаунт</b></a></div>
        </#if>
    </form>
</#macro>

<#macro logout>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit"  class="btn btn-warning">Выйти</button>
</form>
</#macro>

<#macro loginBtn>
    <form action="/login" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit"  class="btn btn-warning">Войти</button>
    </form>
</#macro>