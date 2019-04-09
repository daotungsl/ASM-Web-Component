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
    Integer status = (Integer) request.getAttribute("status");
    Integer role = (Integer) httpSession.getAttribute("role");
    ArrayList<String> listFeedback = (ArrayList<String>) request.getAttribute("listfeedback");

%>
<html>
<head>
    <title>Admin</title>
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
        <h1>Admin form</h1>
        <h3>Username: <%= username%>
        </h3>
        <h3>role: <%
            if (role == 1) {
        %> admin<%
        } else {
        %> user<%
            }%></h3>


        <div class="container">
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#home">List feedback</a></li>
                <li><a data-toggle="tab" href="#menu1">List user</a></li>
            </ul>

            <div class="tab-content">
                <div id="home" class="tab-pane fade in active">
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
                <%--                menu feedback--%>
                <div id="menu1" class="tab-pane fade">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th scope="col">id</th>
                            <th scope="col">Username</th>
                            <th scope="col">Role</th>
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
                            <td>
                                <%
                                    if (role == 1) {
                                %> admin<%
                            } else {
                            %> user<%
                                }%>
                            </td>
                            <td style="display: inline-grid">
                                <%
                                    if (status == 1) {
                                %>
                                <button  style="color: #007bff" class="btn fa fa-check" disabled></button>
                                <%
                                } else {
                                %>
                                <button style="color: #ff6528" class="btn fa fa-bomb" disabled></button>
                                <%
                                    }
                                %>
                                <button style="color: #b21f2d" class="btn fa fa-trash"></button>
                            </td>
                        </tr>
                        <%
                            }%>


                        </tbody>
                    </table>
                </div>

            </div>
        </div>


    </div>
    <div class="col-3">

    </div>
</div>

</body>
</html>
