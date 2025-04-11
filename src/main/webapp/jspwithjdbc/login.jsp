<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<html>
    <head>
        <title>Login page</title>
    </head>
    <body>
        <!-- Error Message Display -->
        <%
            String error = (String) request.getAttribute("errorMessage");
            if (error != null) {
        %>
            <p style="color: red;"><%= error %></p>
        <%
            }
        %>
        <form method='post' action='<%=request.getContextPath()%>/jsp-jdbc-login'>
            <table>
                <tr>
                    <td>Username: </td>
                    <td><input type = 'text' name='txtUsername'></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><input type = 'password' name='txtPassword'></td>
                </tr>
                <tr>
                    <td><input type = 'submit' name='btnSubmit' value='Login'></td>
                    <td><input type = 'submit' name='btnSubmit' value='Register'></td>
                </tr>
            </table>
        </form>
    </body>
</html>