<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users in DB</title>
    </head>
    <body>

        <h1>Users' list</h1>
        <c:if test="${not empty users}">

            <table border='1'>
                <tr>

                    <th>First Name</th>
                    <th>Last Name</th>
                </tr>

                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>User</td>

                    </tr>

                </c:forEach>
            </table>

        </c:if>
        <c:if test="${empty users}">
            <br /><span>Nothing to display.</span>
        </c:if>



    </body>
</html>