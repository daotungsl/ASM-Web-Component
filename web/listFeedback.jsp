<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Daotu
  Date: 08/04/2019
  Time: 1:57 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HttpSession httpSession = request.getSession();
    String username = (String) httpSession.getAttribute("loggedUser");
    int status = (int) request.getAttribute("status");
    int role = (int) request.getAttribute("role");
    ArrayList<String> listFeedback = (ArrayList<String>) request.getAttribute("listfeedback");

%>
<html>
<head>
    <title>List Feedback</title>
</head>
<jsp:include page="include.jsp"/>
<style>
    .btn {
        border: none;
        color: white;
        padding: 12px 16px;
        font-size: 26px;
        cursor: pointer;
    }


    /* Darker background on mouse-over */
    .btn:hover {
        background-color: #5a6268;
    }
</style>
<body>

<div class="container ">

    <div class="col-3">

    </div>

    <div class="col-6">
        <h1>Feedback form</h1>
        <h3>Username: <%= username%>
        </h3>
        <h3>role: <%
            if (role == 0) {
        %> user<%
        } else {
        %> admin<%
            }%></h3>

        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">id</th>
                <th scope="col">Feedback</th>
                <th scope="col">Handle</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (String content :
                        listFeedback) {

            %>
            <tr>
                <th scope="row"><%= status%>
                </th>
                <td><%= content%>
                </td>
                <td style="display: inline-grid">
                    <%
                        if (status == 1) {
                    %>
                    <button style="color: #007bff" class="btn" disabled><i class="fa fa-check"></i></button>
                    <%
                    } else {
                    %>
                    <button style="color: #ff6528" class="btn" disabled><i class="fa fa-bomb"></i></button>
                    <%
                        }
                    %>
                    <button style="color: #b21f2d" class="btn"><i class="fa fa-trash"></i></button>
                </td>
            </tr>
            <%
                }%>


            </tbody>
        </table>
    </div>
    <div class="col-3">

    </div>
</div>

</body>
</html>
