<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employee Register</title>
</head>
<body>
<h2>Employee Registration</h2>

<form:form method="post" modelAttribute="employee" action="/employee/save" >
    <table>
        <tr>
            <td>First Name:</td>
            <td><form:input path="firstName" /></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><form:input path="lastName" /></td>
        </tr>
        <tr>
            <td>Gender:</td>
            <td><form:input path="gender" /></td>
        </tr>
        <tr>
            <td>Date of Birth:</td>
            <td><form:input path="dateOfBirth" /></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><form:input path="email" /></td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td><form:input path="phone" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Save"/>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
