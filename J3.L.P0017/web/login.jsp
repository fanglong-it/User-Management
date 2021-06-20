<%-- 
    Document   : login
    Created on : May 31, 2021, 9:30:32 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
        <title>Login Page</title>
    </head>


    <body>

        <form action="login" method="POST">

            <div class="position-absolute top-50 start-50 translate-middle">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Username</label>

                    <input type="text" name="Username" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">

                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Password</label>
                    <input type="password" name="Password" class="form-control" id="exampleInputPassword1">
                </div>
                <c:if test="${not empty sessionScope.ERROR_MESSAGE}">
                    ${sessionScope.ERROR_MESSAGE}
                </c:if>

                <button type="submit" name ="btnAction" class="btn btn-primary">Submit</button>
            </div>

        </form>



    </body>
</html>
