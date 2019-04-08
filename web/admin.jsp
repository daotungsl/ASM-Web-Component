<%--
  Created by IntelliJ IDEA.
  User: Daotu
  Date: 08/04/2019
  Time: 1:57 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <h3>List feedback</h3>

        <table  class="table table-striped">
            <thead>
            <tr>
                <th scope="col">id</th>
                <th scope="col">Username</th>
                <th scope="col">Feedback</th>
                <th scope="col">Handle</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (int i = 0; i < 10; i++) {%>
            <tr>
                <th scope="row"><%= i%>
                </th>
                <td>Mark <%= i%>
                </td>
                <td> aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa<%= i%>
                </td>
                <td style="display: inline-grid">
                    <button style="color: #007bff" class="btn"><i class="fa fa-question"></i></button>
                    <button style="color: #007bff" class="btn" disabled><i class="fa fa-check"></i></button>
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
