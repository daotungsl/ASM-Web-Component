<%@ page import="com.asm.java.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Daotu
  Date: 22/03/2019
  Time: 11:24 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
//    User user = (User) request.getAttribute("user");
//    if (user == null) {
//        user = new User();
//    }
%>
<html>
<head><title>Login</title></head>
<jsp:include page="include.jsp"/>

<%--<div role="alert" aria-live="assertive" aria-atomic="true" class="toast" data-delay="3000" data-autohide="true">--%>
<%--    <div style="color: #1349e9; font-size:20px" class="toast-header ">--%>
<%--        <i class="fa fa-check"></i>&emsp;--%>
<%--        <strong class="mr-auto">Success</strong>--%>
<%--        <small><i class="fa fa-clock"></i> now</small>--%>

<%--    </div>--%>
<%--    <div class="toast-body">--%>
<%--        You have logged in to your <strong><%= user.getUsername()%>--%>
<%--    </strong> account successfully--%>
<%--    </div>--%>
<%--</div>--%>
<body>

<%--<jsp:include page="login.jsp"/>--%>
<div class="container ">
    <div class="col-3">

    </div>

    <div class="col-6">
        <form action="/login" method="post">
            <h1>Login form</h1>
            <div class="form-group ">
                <label for="exampleInputUsername">User name</label>
                <input type="text" class="form-control" name="username" id="exampleInputUsername"
                       placeholder="Enter username">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" class="form-control" name="password" id="exampleInputPassword1"
                       placeholder="Enter password">
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
            <button type="reset" class="btn btn-dark ">Reset</button>

        </form>
    </div>
    <div class="col-3">

    </div>
</div>
</body>
<%--<script>--%>
<%--    $(document).ready(function () {--%>
<%--        $('.toast').toast('show');--%>
<%--    });--%>
<%--</script>--%>
</html>
