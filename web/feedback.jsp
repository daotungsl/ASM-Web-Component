<%@ page import="com.asm.java.entity.User" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.asm.java.entity.Feedback" %><%--
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
    String content = (String) httpSession.getAttribute("content");
    if (content == null){
        content = "";
    }
    HashMap<String, ArrayList<String>> errors = (HashMap<String, ArrayList<String>>) request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
    }
    Feedback feedback = (Feedback) request.getAttribute("feedback");
    if (feedback == null) {
        feedback = new Feedback();
    }
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

        <form action="/feedback" method="post">
            <div class="form-group row">
                <label for="staticEmail" class="col-sm-2 col-form-label">Username:</label>
                <div class="col-sm-10">
                    <input type="text" readonly class="form-control-plaintext" id="staticEmail" value="<%= username%>">
                </div>
            </div>
            <div class="form-group">
                <label for="exampleFormControlTextarea1">Content feedback</label>
                <textarea class="form-control" placeholder="Please write your feedback here. Maximum 2000 characters" name="content" id="exampleFormControlTextarea1" rows="3" ><%= content%></textarea>
                <%
                    if (errors.containsKey("content")){
                        ArrayList<String> feedbackError = errors.get("content");
                        for (String error :
                                feedbackError) {
                            %>
                <span class="text-danger">- <%= error%></span>
                <br>
                            <%
                        }
                    }

                %>
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
