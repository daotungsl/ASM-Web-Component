<%--
  Created by IntelliJ IDEA.
  User: Daotu
  Date: 22/03/2019
  Time: 11:24 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%%>
<html>
<head><title>Login</title></head>
<body>


<h1>Login</h1>


<h3>Enter user name and password:</h3>

<form name='f' action=/login method='POST'>
    <table>
        <tr>
            <td>User:</td>
            <td><input type='text' name='username' value=''></td>

        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
            <td><input name="reset" type="reset" value="reset" /></td>
        </tr>
    </table>
</form>
</body>
</html>
