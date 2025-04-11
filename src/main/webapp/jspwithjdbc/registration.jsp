<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>Login page</title>
    </head>
    <body>
        <form method='post' action='<%=request.getContextPath()%>/jsp-jdbc-registration'>
            <table>
                <tr>
                    <td>Create Username: </td>
                    <td><input type = 'text' name='txtUsername'></td>
                </tr>
                <tr>
                    <td>Create Password: </td>
                    <td><input type = 'password' name='txtPassword'></td>
                </tr>
                <tr>
                    <td><input type = 'submit' name='btnSubmit' value='Register'></td>
                </tr>
            </table>
        </form>
    </body>
</html>