<#include "security.ftlh">
<#import "pager.ftlh" as p>

<@p.pager url page />
<div class="card-columns">
    <#list page.content as message>
        <div class="card border-warning text-white bg-dark my-3">
            <#if message.filename??>
                <img src="/img/${message.filename}" class="card-img-top p-2">
            </#if>
            <div class="m-2">
                <span>${message.text}</span>
                <br/>
                <#if message.tag??>
                    <i>#${message.tag}</i>
                </#if>
            </div>
            <div class="card-footer text-muted d-flex justify-content-between">
                <a class="text-warning" href="/user-messages/${message.author.id}">${message.authorName}</a>
                <#if message.author.id == currentUserId>
                    <a class="btn btn-outline-warning" href="/user-messages/${message.author.id}?message=${message.id}">
                        Edit
                    </a>
                </#if>
            </div>
        </div>
    <#else>
        No message
    </#list>
</div>

<@p.pager url page />