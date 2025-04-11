<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
    <body>
        <h2>User Details</h2>

        <jsp:useBean id="myUser" class = "bean.User" scope="session"/>
        <jsp:setProperty name="myUser" property="name" value="DevTamakuwala"/>
        <jsp:setProperty name="myUser" property="email" value="dev@gmail.com"/>


        <p>Name: <jsp:getProperty name="myUser" property="name"/></p>
        <p>Email: <jsp:getProperty name="myUser" property="email"/></p>

        <hr>
        <h3>Modify User Details</h3>
        <form action="updateuser.jsp" method="post">
            <label for="name">Name:</;label>
            <input type="text" id="name" name="name" value="<jsp:getProperty name='myUser' property='name'/>">
            <br><br>
            <label for="email">Email:</;label>
            <input type="text" id="email" name="email" value="<jsp:getProperty name='myUser' property='email'/>">
            <br><br>
            <input type="submit" value="Update User">
        </form>
    </body>
</html>