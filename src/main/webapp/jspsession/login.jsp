<%@ page language="java" %>

<html>
    <body>
        <%
            String username = request.getParameter("username");

            if(username != null && !username.isEmpty()){
                session.setAttribute("user", username);
        %>
                <h2>Welcome, <%= username%>!</h2>
                <a href="dashboard.jsp">Go to dashboard</a>
        <%
            } else {
        %>
                <form method="post">
                    Username: <input method="text" name="username">
                    <input type="submit" value="Login">
                </form>
        <%

            }
        %>
    </body>
</html>