<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
<div><b>Login page</b></div>
<@l.login "/login" "Sign In"/>
<a href="/registration">Create account</a>
</@c.page>