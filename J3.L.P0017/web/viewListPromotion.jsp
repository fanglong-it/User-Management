<%-- 
    Document   : viewListPromotion
    Created on : Jun 19, 2021, 2:29:01 PM
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



        <title>Promotion Info</title>
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
        <h1>Info of Promotion</h1>


        <form action="updatePromotionInfo">
            <div class="d-flex justify-content-center">
                <c:if test="${empty sessionScope.LIST_TMP}">
                    not found
                </c:if>
                <c:if test="${not empty sessionScope.LIST_TMP}">

                    <table class="table table-fixed w-75" >
                        <thead>
                            <tr>
                                <th scope="col">Num.</th>
                                <th scope="col">Username</th>
                                <th scope="col">Date Added</th>
                                <th scope="col">Promotion Id</th>
                                <th scope="col">Promotion Value</th>


                                <th scope="col"></th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${sessionScope.LIST_TMP}" var="o" varStatus="Counter" >
                            <form action="updatePromotionInfo"> 

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

                                        <select name="txtValue" >
                                            <option selected="" value="${o.getValue()}">${o.getValue()}</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                            <option value="6">6</option>
                                            <option value="7">7</option>
                                            <option value="8">8</option>
                                            <option value="9">9</option>
                                            <option value="10">10</option>
                                        </select>
                                    </td>
                                    <td>
                                        <button class="btn btn-success" type="submit">Update</button>

                                        <a class="btn btn-danger" href="deletePromotion?txtUsername=${o.getUsername()}">Delete</a>
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
