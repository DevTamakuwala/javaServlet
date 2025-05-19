<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.Date" %>
<%
    String username = request.getParameter("username");
    if (username != null && !username.trim().isEmpty()) {
        session.setAttribute("username", username);
        session.setAttribute("loginTime", new Date());
    } else {
        // Handle the case where the username is null or empty
        response.sendRedirect("index.jsp"); // Redirect to the input page
        return; // Stop further execution of this page
    }

    Date loginTime = (Date) session.getAttribute("loginTime");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Hello</title>
    <style>
        .header {
            position: absolute;
            top: 10px;
            right: 10px;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <h2>Hello, <%= session.getAttribute("username") %></h2>
    <div class="header">
        Login Time: <%= loginTime %>
    </div>
    <form action="logout.jsp" method="post">
        <input type="submit" value="Logout">
    </form>
</body>
</html>