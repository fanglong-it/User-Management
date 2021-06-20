<%-- 
    Document   : error
    Created on : Jun 10, 2021, 7:22:48 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:if test="${not empty sessionScope.ERROR_MESSAGE}">
            ${sessionScope.ERROR_MESSAGE}
        </c:if>
    </body>
</html>
