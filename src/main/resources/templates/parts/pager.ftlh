<!--page param - from repo -->
<#macro pager url page>
    <#if page.getTotalPages() gt 7>
        <#assign
            totalPages = page.getTotalPages()
            pageNumber = page.getNumber + 1

            head = (pageNumber > 4)?then([1, -1], [1,2,3])
            tail = (pageNumber < totalPages-3)?then([-1, totalPages], [totalPages - 2, totalPages - 1, totalPages])
            bodyBefore = (pageNumber > 4 && pageNumber < totalPages-1)?then([pageNumber-2, pageNumber-1],[])
            bodyAfter = (pageNumber > 2 && pageNumber < totalPages-3)?then([pageNumber+1, pageNumber+2],[])

            body = head + bodyBefore + (pageNumber > 3 && pageNumber < totalPages-2)?then([pageNumber], []) + bodyAfter + tail
        />
    <#else>
        <#assign body = 1..page.getTotalPages()/>
    </#if>
    <div class="container" style="margin-right: 1%">
        <div class="mt-1 row justify-content-end" >
            <ul class="pagination col-auto ">
                <li class="page-item disabled">
                    <a class="page-link" href="#" tabindex="-1">Страница</a>
                </li>
                <#list body as p>
                    <#if (p - 1) == page.getNumber()>
                        <li class="page-item list-group-item-warning">
                            <a class="page-link list-group-item-warning" href="#" tabindex="-1">${p}</a>
                        </li>
                    <#elseif p == -1>
                        <li class="page-item disabled">
                            <a class="page-link" href="#" tabindex="-1">...</a>
                        </li>
                    <#else>
                        <li class="page-item">
                            <a class="page-link" href="${url}?page=${p-1}&size=${page.getSize()}" tabindex="-1">${p}</a>
                        </li>
                    </#if>
                </#list>
            </ul>
            <div class="dropdown col-auto">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Количество элементов
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <#list [6,12,24] as c>
                        <#if (c) == page.getSize()>
                                <a class="dropdown-item" href="#" tabindex="-1">${c}</a>
                        <#else>
                                <a class="dropdown-item" href="${url}?page=${page.getNumber()}&size=${c}" tabindex="-1">${c}</a>
                        </#if>
                    </#list>
                </div>
            </div>
        </div>
    </div>
</#macro>