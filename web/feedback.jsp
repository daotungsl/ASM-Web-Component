<%@ page import="com.asm.java.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Daotu
  Date: 08/04/2019
  Time: 1:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HttpSession httpSession = request.getSession();
    String username = (String) httpSession.getAttribute("loggedUser");
//    if (user == null) {
//        user = new User();
//    }
%>
<html>
<head>
    <title>Feedback</title>
</head>
<jsp:include page="include.jsp"/>
<body>
<div class="container ">

    <div class="col-3">

    </div>

    <div class="col-6">
        <h1>Feedback form</h1>

        <form>
            <div class="form-group row">
                <label for="staticEmail" class="col-sm-2 col-form-label">Username:</label>
                <div class="col-sm-10">
                    <input type="text" readonly class="form-control-plaintext" id="staticEmail" value="<%= username%>">
                </div>
            </div>
            <div class="form-group">
                <label for="exampleFormControlTextarea1">Content feedback</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Confirm</button>
            <button type="reset" class="btn ">Reset</button>
        </form>
    </div>
    <div class="col-3">

    </div>
</div>

</body>
</html>
