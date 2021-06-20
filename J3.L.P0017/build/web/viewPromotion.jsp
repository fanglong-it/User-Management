<%-- 
    Document   : viewPromotion
    Created on : Jun 19, 2021, 9:19:09 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous"><!-- JavaScript Bundle with Popper -->
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script> <title>Admin</title>


        <title>View Promotion</title>
    </head>
    <body>
        <h1>View Promotion</h1>

        <div class="position-absolute top-0 end-0">
            <c:if test="${empty sessionScope.USER}">
                <c:redirect url="login.jsp"/>
            </c:if>
            <c:if test="${sessionScope.USER.getRole() ne '1'}">
                <c:redirect url="login.jsp"/>
            </c:if>
            welcome, ${sessionScope.USER.getName()}

            <form action="logout">
                <input class="btn btn-danger" type="submit" value="Logout" />
            </form>
        </div>


        <div class="d-flex justify-content-center">
            <a href="savePromotion?" class="btn btn-secondary">Save to database</a>
        </div>
        <form action="search">
            <div class="d-flex justify-content-center">

                <c:if test="${empty sessionScope.PROMOTION}">
                    not found
                </c:if>
                <c:if test="${not empty sessionScope.PROMOTION}">

                    <table class="table table-fixed w-75" >
                        <thead>
                            <tr>
                                <th scope="col">Num.</th>
                                <th scope="col">Promotion Id</th>
                                <th scope="col">Name</th>
                                <th scope="col"></th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${sessionScope.PROMOTION}" var="o" varStatus="Counter" >

                                <tr>
                                    <th scope="row">${Counter.count}</th>

                                    <td>
                                        <input type="hidden" name="txtPromotionId" value="${o.getPromotionId()}" />
                                        ${o.getPromotionId()}
                                    </td>
                                    <td>
                                        ${o.getName()}
                                    </td>
                                    <td>
                                        <a class="btn btn-success" href="viewPromotionInfo?txtPromotionId=${o.getPromotionId()}">Manage</a>
                                        <a class="btn btn-danger" href="viewUserPromotion?txtPromotionId=${o.getPromotionId()}">Add</a>
                                    </td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </c:if>

            </div>
        </form>

    </body>
</html>
