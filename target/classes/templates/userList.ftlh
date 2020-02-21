<#import "parts/common.ftlh" as c>

<@c.page>
    <div>List of users</div>
    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Role</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.username!"null or missing"}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><a href="/user/${user.id}">edit</a></td>
            </tr>
        <#else>
            No Users
        </#list>
        </tbody>
    </table>
</@c.page>