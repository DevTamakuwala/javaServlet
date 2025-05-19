
<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.Date" %>
<%
    Date loginTime = (Date) session.getAttribute("loginTime");
    String username = (String) session.getAttribute("username");
    session.invalidate(); // Clear the entire session

    Date logoutTime = new Date();
    long duration = 0;
    if (loginTime != null) {
       duration = logoutTime.getTime() - loginTime.getTime();
    }
    long durationSeconds = duration / 1000;
%>
<!DOCTYPE html>
<html>
<head>
    <title>Logout</title>
</head>
<body>
    <h2>Thank You, <%= username %></h2>
    <p>You were logged in for <%= durationSeconds %> seconds.</p>
    <a href="index.jsp">Login Again</a>
</body>
</html>