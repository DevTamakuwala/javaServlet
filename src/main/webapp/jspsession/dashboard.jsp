<%@ page language="java"%>

<html>
    <body>
        <%
            String  user = (String) session.getAttribute("user");
            if(user != null){
        %>
                <h2>Hello, <%= user%>! This is your dashboard.</h2>
                <a href="logout.jsp">Logout</a>
        <%
            } else {
        %>
                <h2>You are logged out!</h2>
                <a href="login.jsp">Go to Login</a>
        <%
            }
        %>
    </body>
</html>