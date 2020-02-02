<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

<title>
List Employee
</title>
<link type="text/css" 
rel="stylesheet"
href="${pageContext.request.contextPath}/resources/css/style.css "
/>
</head>
<body>
<div id="wrapper">
<div id="header">
<h2>ERM - Employee Relationship Manager</h2>
</div>
</div>


<div id="container">
<div id="content">

<input type="button" value="Add Employee"
       onclick="window.location.href='showFormForAdd'; return false;"
      class="add-button"
 />
<!--  add a search box -->
            <form:form action="search" method="GET">
                Search Employee: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>

<!-- add html table  -->
<table>
<tr>
<th>First Name</th>
<th>last Name</th>
<th>Email</th>
<th>Action</th>
<tr>

<!-- loop over and print our customer -->
<c:forEach var="tempCustomer" items="${customers}">
<c:url var="updateLink" value="/customer/showFormForUpdate">
<c:param name="customerId" value="${tempCustomer.id}"></c:param>
</c:url>
<c:url var="deleteLink" value="/customer/delete">
<c:param name="customerId" value="${tempCustomer.id}"></c:param>
</c:url>
<tr>
<td> ${tempCustomer.firstName} </td>
<td> ${tempCustomer.lastName} </td>
<td> ${tempCustomer.email} </td>
<td> 
<a href="${updateLink }">Update</a>
<a href="${deleteLink }"
OnClick="if (!(confirm('Are you sure?'))) return false">Delete</a>
 </td>
</tr>
</c:forEach>


</table>
</div>

</div>
</body>


</html>