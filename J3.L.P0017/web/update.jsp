<%-- 
    Document   : update
    Created on : Jun 17, 2021, 12:54:25 PM
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


        <title>Update Page</title>
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
        
        <c:if test="${empty sessionScope.USER_INFO}">
            <c:redirect url="login.jsp"/>
        </c:if>

        <div class="position-absolute top-50 start-50 translate-middle w-75 p-3" style="">
            <form class="row g-3" action="update">

                <div class="col-md-6">
                    <input type="hidden" name="txtLoginUsername" value="${sessionScope.USER.getUsername()}" />
                    Username
                    <input type="hidden" name="txtUsername" value="${sessionScope.USER_INFO.getUsername()}" />
                    <input type="text" class="form-control" value="${sessionScope.USER_INFO.getUsername()}" disabled>
                </div>
                <div class="col-md-6">
                    Photo:
                    <a href="https://imgbb.com/"><img src="${sessionScope.USER_INFO.getPhotoCode()}" alt="download" border="0" style=“width:128px;height:128px;"></a>

                    <input type="text" name="txtPhotoCode" class="form-control" value="${sessionScope.USER_INFO.getPhotoCode()}" />
                </div>


                <div class="col-12">
                    Name
                    <input type="text" class="form-control" name="txtName" value="${sessionScope.USER_INFO.getName()}">
                </div>
                <div class="col-md-6">
                    <label for="inputEmail14" class="form-label">Email</label>
                    <input type="Email" class="form-control" id="inputEmail4" name="txtEmail" value="${sessionScope.USER_INFO.getEmail()}">
                </div>
                <div class="col-md-4">

                    <label for="inputPhone" class="form-label">Phone Number</label>
                    <input type="tel" pattern="[0-9]{9,10}" class="form-control" name="txtPhoneNumber" value="${sessionScope.USER_INFO.getPhoneNumber()}">

                </div>
                <div class="col-md-2">
                    <label for="" class="form-label">Role</label>

                    <select name="txtRole" class="form-select" >
                        <option hidden="" selected="" value="${sessionScope.USER_INFO.getRole()}">

                            <c:if test="${sessionScope.USER_INFO.getRole() eq 1}">
                                Admin
                            </c:if>
                            <c:if test="${sessionScope.USER_INFO.getRole() eq 0}">
                                User
                            </c:if>
                        </option>
                        <option value="0">User</option>
                        <option value="1">Admin</option>
                    </select>
                </div>
                <div class="col-md-2">
                    Status

                    <select name="txtStatus" class="form-select" >
                        <option hidden="" selected="" value="${sessionScope.USER_INFO.getStatus()}">
                            ${sessionScope.USER_INFO.getStatus()}
                        </option>
                        <option value="Active">Active</option>
                        <option value="InActive">InActive</option>
                    </select>
                </div>
                <div class="col-12">
                    <input type="hidden" name="txtPassword" value="${sessionScope.USER_INFO.getPassword()}" />

                    New Password

                    <input type="password" class="form-control" name="txtNewPassword" value="">
                </div>
                <div class="col-12">
                    Confirm Password
                    <input type="password" class="form-control" name="txtRePassword" value="">
                </div>

                <c:if test="${not empty sessionScope.ERROR_UPDATE}">
                    ${sessionScope.ERROR_UPDATE}
                </c:if>

                <div class="col-12">
                    <button type="submit" class="btn btn-primary">Update</button>
                </div>
            </form>
        </div>


    </body>
</html>
