<%-- 
    Document   : listAllUsers
    Created on : May 20, 2014, 5:15:30 PM
    Author     : bin
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of All Users</title>
    </head>
    <body>
       
    <h1>List of All Users</h1>
        <table border="1" cellpadding="10">
             <tr>
                    <th>No</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Advisor Name</th>
                    <th>Assign Advisor</th>
                </tr>
            <c:forEach var="user" items="${allusers}">
               
                <tr>
                    <td>${user.id}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    
                    <td>${user.advisor.firstName}&nbsp;${user.advisor.lastName}</td>
                   
                    <td>
                        <form action="assignAdvisor/${user.id}" method="post">
                        <select name="advisor" >
                            <option value="NONE" label="--- Select ---" />
                        <c:forEach items="${faculties}" var="fac" >
                            
                            <option value="${fac.id}" label="${fac.firstName}" />                     
                         </c:forEach>  
                        </select> 
                        <input type="submit" value="Assign" />
                         </form> 
                        
                    </td>
                      
                        
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
