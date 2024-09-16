<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>Users List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>Name</th><th>Salary</th><th>Designation</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="user" items="${list}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.salary}</td>
            <td>${user.designation}</td>
            <td><a href="edituser/${user.id}">Edit</a></td>
            <td><a href="deleteuser/${user.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="userform">Add New User</a>