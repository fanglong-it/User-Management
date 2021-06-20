<%-- 
    Document   : viewUserPromotion
    Created on : Jun 19, 2021, 10:01:33 PM
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

            <c:if test="${ not empty requestScope.ERROR_MESSAGE}">
                <p style="color: red">${requestScope.ERROR_MESSAGE}</p>
            </c:if>

            <form action="addUserPromotion">
                <div class="d-flex justify-content-center">
                    <c:if test="${empty requestScope.LIST_USER}">
                        not found
                    </c:if>
                    <c:if test="${not empty requestScope.LIST_USER}">

                        <table class="table table-fixed w-75" >
                            <thead>
                                <tr>
                                    <th scope="col">Num.</th>
                                    <th scope="col">Username</th>
                                    <th scope="col">Photo</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Phone Number</th>
                                    <th scope="col">Role</th>
                                    <th scope="col">Status</th>
                                    <th scope="col">Action</th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.LIST_USER}" var="o" varStatus="Counter" >
                                <form action="addUserPromotion">
                                    <tr>
                                        <th scope="row">${Counter.count}</th>

                                        <td>
                                            <input type="hidden" name="txtUsername" value="${o.getUsername()}" />
                                            ${o.getUsername()}
                                        </td>
                                        <td>
                                            <a href="https://imgbb.com/"><img src="${o.getPhotoCode()}" alt="download" border="0" style=“width:128px;height:128px;"></a>
                                        </td>
                                        <td>${o.getName()}</td>
                                        <td>${o.getEmail()}</td>
                                        <td>${o.getPhoneNumber()}</td>
                                        <td>${o.getRole()}</td>
                                        <td>${o.getStatus()}</td>
                                        <td>


                                            <input type="hidden" name="txtPromotionId" value="${requestScope.PROMOTION_ID}" />

                                            <button type="submit" class="btn-success">Add</button>
                                        </td>
                                    </tr>
                                </form>
                            </c:forEach>
                            </tbody>
                        </table>

                    </c:if>

                </div>
            </form>




        </div>
    </body>
</html>
