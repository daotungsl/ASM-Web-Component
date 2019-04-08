<%@ page import="java.util.HashMap" %>
<%@ page import="com.sample.java.entity.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Daotu
  Date: 22/03/2019
  Time: 11:24 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String title = (String) request.getAttribute("title");
    HashMap<String, ArrayList<String>> errors = (HashMap<String, ArrayList<String>>) request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
    }
    User user = (User) request.getAttribute("user");
    if (user == null) {
        user = new User();
    }
%>
<html>
<jsp:include page="register.jsp">
    <jsp:param name="title" value="<%= title%>"/>
    <jsp:param name="description" value="Mô tả"/>
    <jsp:param name="keywords" value="keyword1, keyword2"/>


</jsp:include>
<head><title>Login</title></head>
<body>

<jsp:include page="login.jsp"/>
<div class="content">
    <h1><%= (String) request.getAttribute("title")%>
    </h1>
    <fieldset>
        <legend>Register form</legend>
        <form action="/user" method="post">
            Username <input type="text" name="username" value="<%= user.getUsername()%>">
            <% if (errors.containsKey("username")) {
                ArrayList<String> userNameError = errors.get("username");
                for (String error :
                        userNameError) {
                    %>
                    <span class="msg-error"><%= error.get("username")%></span>
                    <%
                    }
                }
            %>
            <br>
            <input name="submit" type="submit" value="submit"/>
            <br>
            <input name="reset" type="reset" value="reset"/>
        </form>
    </fieldset>
</div>

</body>
</html>
