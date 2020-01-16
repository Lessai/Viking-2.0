<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="form-row mb-2">
        <form class="form-inline" method="get" action="/main">
            <input  class="form-control" type="text" name="filter" value="${filter!}" placeholder="Search by tag">
            <button type="submit" class="btn btn-warning ml-2">Search</button>
        </form>
    </div>
    <a class="btn btn-warning" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Add new message
    </a>
    <div class="collapse <#if message??>show</#if>" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" name="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                           value = "<#if message??>${message.text}</#if>"
                           placeholder="Enter message"> <!-- if entered by user is incorrect, user loose entered data and see the message -->
                    <#if textError??> <!-- if textError attribute exists in our model -->
                        <div class="invalid-feedback">
                            ${textError}
                        </div>
                    </#if>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control"
                           value="<#if message??>${message.tag}</#if>" name="tag" placeholder="Tag">
                    <#if tagError??>
                        <div class="invalid-feedback">
                            ${tagError}
                        </div>
                    </#if>
                </div>
                <div class="form-group">
                    <div class="custom-file">
                        <input type="file" name="file" id="customFile">
                        <label class="custom-file-label" for="customFile">${fileName!'Choose file'}</label>
                    </div>
                </div>
                <div class="form-group">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-warning">Add</button>
                </div>
            </form>
        </div>
    </div>
    <br>

    <div class="card-columns">
        <#list messages as message>
            <div class="card border-warning text-white bg-dark my-3">
                <#if message.filename??>
                    <img src="/img/${message.filename}" class="card-img-top p-2">
                </#if>
                <div class="m-2">
                    <span>${message.text}</span>
                    <#if message.tag??>
                        <i>#${message.tag}</i>
                    </#if>
                </div>
                <div class="card-footer text-muted">
                    ${message.authorName}
                </div>
            </div>
        <#else>
            No message
        </#list>
    </div>
</@c.page>