<#macro login path submitValue isRegistrForm >
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"><b> User Name: </b></label>
            <div class="col-sm-6">
                <input type="text" name="username" value="<#if user??>${user.username}</#if>"
                       class="form-control ${(usernameError??)?string('is-invalid', '')}"
                       placeholder="User name"/>
                <#if usernameError??>
                    <div class="invalid-feedback">
                        ${usernameError}
                    </div>
                </#if>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"><b> Password: </b></label>
            <div class="col-sm-6">
                <input type="password" name="password"
                       class="form-control ${(passwordError??)?string('is-invalid', '')}"
                       placeholder="Password"/>
                <#if passwordError??>
                    <div class="invalid-feedback">
                        ${passwordError}
                    </div>
                </#if>
            </div>
        </div>
        <#if isRegistrForm>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label"> Retype Password: </label>
                <div class="col-sm-6">
                    <input type="password" name="password2"
                           class="form-control ${(password2Error??)?string('is-invalid', '')}"
                           placeholder="Retype Password"/>
                    <#if password2Error??>
                        <div class="invalid-feedback">
                            ${password2Error}
                        </div>
                    </#if>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Email: </label>
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
            <div class="col-sm-6">
                <div class="g-recaptcha" data-sitekey="6LfX6M8UAAAAALJpzzQwOZHNqJ9sFzUl11TICKAA"></div>
                <#if captchaError??>
                    <div class="alert alert-danger" role="alert">
                        ${captchaError}
                    </div>
                </#if>
            </div>
        </#if>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-warning">${submitValue}</button>
        <#if !isRegistrForm>
            <div class="mt-1"><a class="text-info" href="/registration"><b>Create account</b></a></div>

        </#if>
    </form>
</#macro>

<#macro logout>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit"  class="btn btn-warning">Sign Out</button>
</form>
</#macro>

<#macro loginBtn>
    <form action="/login" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit"  class="btn btn-warning">Sign In</button>
    </form>
</#macro>