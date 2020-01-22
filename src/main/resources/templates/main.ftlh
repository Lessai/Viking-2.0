<#import "parts/common.ftlh" as c>

<@c.page>
    <!-- Search -->
    <div class="form-row mb-2">
        <form class="form-inline" method="get" action="/main">
            <input  class="form-control" type="text" name="filter" value="${filter!}" placeholder="Search by tag">
            <button type="submit" class="btn btn-warning ml-2">Search</button>
        </form>
    </div>

    <!--Message Editor-->
    <#include "parts/messageEdit.ftlh" />

    <!-- All messages -->
    <#include "parts/messageList.ftlh" />

</@c.page>