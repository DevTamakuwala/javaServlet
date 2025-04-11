<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>User information</title>
    </head>
    <body>

    <h2>Registered User</h2>

    <jsp:useBean id="myUser" class="bean.User2" scope="session" />

    <jsp:setProperty name="myUser" property="name" param="name" />
    <jsp:setProperty name="myUser" property="age" param="age" />
    <jsp:setProperty name="myUser" property="email" param="email" />

    <p>Name: <jsp:getProperty name="myUser" property="name" /></p>
    <p>Email: <jsp:getProperty name="myUser" property="email" /></p>
    <p>Age: <jsp:getProperty name="myUser" property="age" /></p>

    <a href="register_user.jsp">Back to User Info</a>

    </body>
</html>
