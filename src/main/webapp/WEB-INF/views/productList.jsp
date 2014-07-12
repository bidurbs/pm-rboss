<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products currently in the shop</title>
    </head>
    <body>

        <h1>Products</h1>
        <table border='1'>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.description}</td>
                    <td>
                        <form:form commandName="product" action="${pageContext.request.contextPath}/cart/${product.id}" method="post">
                        <input type="submit" value="Add to cart"/>
                        
                    </td>
                    
                    <td>Quantity
                        <input type="text" name="quantity" size="3"/>
                        </form:form>
                    </td>
                    <sec:authorize access="hasRole('ROLE_ADMIN')" >
                        <td><a href="products/${product.id}">edit</a></td>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ROLE_ADMIN')" >
                        <td><a href="products/${product.id}">delete</a></td>
                    </sec:authorize>
                </tr>
                   <%--</form:form>--%> 
            </c:forEach>
        </table>
        
        
        


    </body>
</html>