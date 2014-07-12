<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit User</title>
      
    </head>
    <body>
  
        <h1>Edit User</h1>
        <form:form commandName="customer" action="../customers/${customer.id}" method="post">
            <form:hidden path="id" />
            <form:errors path="*" cssClass="errorblock" element="div" />
            <table>
                <tr>
                    <td>First Name :</td>
                    <td><form:input path="firstName" /> </td>
                    <td><form:errors path="firstName" cssClass="error" /> </td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><form:input path="lastName" /> </td>
                    <td><form:errors path="lastName" cssClass="error" /> </td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><form:input path="email" /> </td>
                    <td><form:errors path="email" cssClass="error" /> </td>
                </tr>
                <tr>
                    <td>User Name</td>
                    <td><form:input path="userName" /> </td>
                    <td><form:errors path="userName" cssClass="error" /> </td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><form:input path="password" /> </td>
                    <td><form:errors path="password" cssClass="error" /> </td>
                </tr>
            </table>
            <input type="submit" value="update"/>
        </form:form>       
        
        <form action="delete?customerId=${customer.id}" method="post">
            <button type="submit">Delete</button>
        </form>
             
    </body>
</html>