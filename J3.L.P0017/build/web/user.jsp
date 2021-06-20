<%-- 
    Document   : user
    Created on : Jun 10, 2021, 7:16:27 AM
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
            <c:if test="${sessionScope.USER.getRole() eq '1'}">
                <c:redirect url="login.jsp"/>
            </c:if>
            welcome, ${sessionScope.USER.getName()}

            <form action="logout">
                <input class="btn btn-danger" type="submit" value="Logout" />
            </form>
        </div>


        <div class="position-absolute top-50 start-50 translate-middle w-75 p-3" style="">
            <form class="row g-3">
                <div class="col-md-6">
                    Username
                    <input type="text" class="form-control" value="${sessionScope.USER.getUsername()}">
                </div>
                <div class="col-md-6">
                    Photo
                    <a href="https://imgbb.com/"><img src="${sessionScope.USER.getPhotoCode()}" alt="download" border="0" style=“width:128px;height:128px;"></a>

                </div>
                <div class="col-12">
                    Password
                    <input type="text" class="form-control" value="${sessionScope.USER.getPassword()}">
                </div>

                <div class="col-12">
                    Name
                    <input type="text" class="form-control" id="" value="${sessionScope.USER.getName()}">
                </div>
                <div class="col-md-6">
                    <label for="inputEmail14" class="form-label">Email</label>
                    <input type="Email" class="form-control" id="inputEmail4" value="${sessionScope.USER.getEmail()}">
                </div>
                <div class="col-md-4">

                    <label for="inputPhone" class="form-label">Phone Number</label>
                    <input type="text" class="form-control" id="" value="${sessionScope.USER.getPhoneNumber()}">

                </div>
                <div class="col-md-2">
                    <label for="" class="form-label">Role</label>
                    <input type="text" class="form-control" id="" value="${sessionScope.USER.getRole()}">
                </div>
                <div class="col-md-2">
                    <label for="inputZip" class="form-label">Status</label>
                    <select name="Option" class="form-select" id="inlineFormSelectPref" >
                        <option selected="${sessionScope.USER.getStatus()}" value="1">Active</option>
                        <option selected="${sessionScope.USER.getStatus()}" value="2">InActive</option>
                    </select>
                </div>

                    <c:if test="${not empty sessionScope.USER_PROMOTION}">
                        
                        <div class="col-md-5">

                            <label class="form-label">Promotion Name:</label>
                            <input type="text" class="form-control" id="" value="${sessionScope.USER_PROMOTION.getPromotionId()}">

                        </div>
                        <div class="col-md-5">

                            <label class="form-label">Date Added:</label>
                            <input type="text" class="form-control" id="" value="${sessionScope.USER_PROMOTION.getDateAdded()}">

                        </div>

                    </c:if>



            </form>
        </div>

    </body>
</html>
