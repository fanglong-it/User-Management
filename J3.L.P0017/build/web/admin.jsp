<%-- 
    Document   : admin
    Created on : Jun 10, 2021, 7:16:16 AM
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
            <form action="search" class="row row-cols-lg-auto g-3 align-items-center position-absolute top-20 start-50 translate-middle-x mb-3">
                <div class="col-12">
                    <label class="visually-hidden" for="inlineFormInputGroupUsername">Username</label>
                    <div class="input-group">
                        <input type="text" name="SearchName" value="${param.SearchName}" class="form-control" id="inlineFormInputGroupUsername" placeholder="Input Name for search">
                    </div>
                </div>
                <div class="col-12">
                    <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
                    <select name="Option" class="form-select" id="inlineFormSelectPref">
                        <option value="All">All</option>
                        <option value="Admin">Admin</option>
                        <option value="User">User</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-success">Search by name</button>


            </form>
        </div>
        <br>
        <br>
        <br>

        <div class="d-flex justify-content-center">
            <a class="btn btn-secondary" href="createAccount.jsp">Create Account</a>

            <a class="btn btn-danger" href="viewPromotion?">View Promotion</a>

            <a class="btn btn-warning" href="viewHistoryPromotion.jsp">View History</a>
        </div>
        <br>
        <br>
        <br>
        <form action="search">
            <div class="d-flex justify-content-center">
                <c:if test="${empty sessionScope.LISTUSER}">
                    not found
                </c:if>
                <c:if test="${not empty sessionScope.LISTUSER}">

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
                            <c:forEach items="${sessionScope.LISTUSER}" var="o" varStatus="Counter" >

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
                                        <c:if test="${o.getRole() eq '1' }">
                                            <a class="btn btn-warning" href="viewInfo?txtUsername=${o.getUsername()}">Manage</a>
                                        </c:if>
                                        <c:if test="${o.getRole() ne '1' }">
                                            <a class="btn btn-danger" href="delete?txtUsername=${o.getUsername()}">Delete</a>
                                            <a class="btn btn-warning" href="viewInfo?txtUsername=${o.getUsername()}">Manage</a>
                                        </c:if>
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
