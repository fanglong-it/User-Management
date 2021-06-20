<%-- 
    Document   : viewHistoryPromotion
    Created on : Jun 20, 2021, 2:06:20 AM
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

        <title>JSP Page</title>
    </head>
    <body>

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


            <form action="viewHistoryPromotion" class="row row-cols-lg-auto g-3 align-items-center position-absolute top-20 start-50 translate-middle-x mb-3">
                <div class="col-12">
                    <input type="date" id="birthday" name="birthday">
                </div>
                <div class="col-12">
                <button class="btn btn-warning" type="submit">View history</button>
                </div>
                <a class="btn btn-success" href="admin.jsp">Manage Page</a>
            </form>
        </div>
        <br>
        <br>
        <form action="viewHistoryPromotion">
            <div class="d-flex justify-content-center">
                <c:if test="${empty sessionScope.HISTORY_PROMOTION}">
                    not found
                </c:if>
                <c:if test="${not empty sessionScope.HISTORY_PROMOTION}">

                    <table class="table table-fixed w-75" >
                        <thead>
                            <tr>
                                <th scope="col">Num.</th>
                                <th scope="col">Username</th>
                                <th scope="col">Date Added</th>
                                <th scope="col">Promotion Id</th>
                                <th scope="col">Promotion Value</th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${sessionScope.HISTORY_PROMOTION}" var="o" varStatus="Counter" >
                            <form action="viewHistoryPromotion">
                                <tr>
                                    <th scope="row">${Counter.count}</th>

                                    <td>
                                        <input type="hidden" name="txtUsername" value="${o.getUsername()}" />
                                        ${o.getUsername()}
                                    </td>
                                    <td>
                                        ${o.getDateAdded()}
                                    </td>
                                    <td>
                                        <input type="hidden" name="txtPromotionId" value="${o.getPromotionId()}" />
                                        ${o.getPromotionId()}
                                    </td>
                                    <td>
                                        ${o.getValue()}
                                    </td>
                                </tr>
                            </form>
                        </c:forEach>
                        </tbody>
                    </table>

                </c:if>

            </div>
        </form>
    </body>
</html>
