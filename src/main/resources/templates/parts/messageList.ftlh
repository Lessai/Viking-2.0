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
            <div class="card-footer text-muted container">
                <div class="row">
                    <a class="col text-warning align-self-center" href="/user-messages/${message.author.id}">${message.authorName}</a>
                    <a class="col text-warning align-self-center" href="/messages/${message.id}/like">
                        <#if message.meLiked>
                            <i class="fas fa-heart"></i>
                        <#else>
                            <i class="far fa-heart"></i>
                        </#if>
                        ${message.likes}
                    </a>
                    <#if message.author.id == currentUserId>
                        <a class="btn btn-outline-warning" href="/user-messages/${message.author.id}?message=${message.id}">
                            Edit
                        </a>
                    </#if>
                </div>
            </div>
        </div>
    <#else>
        No message
    </#list>
</div>

<@p.pager url page />