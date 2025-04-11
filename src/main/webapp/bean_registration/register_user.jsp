<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
    <body>
        <h2>Register User</h2>

        <jsp:useBean id="myUser" class = "bean.User2" scope="session"/>
        <form action="all_users.jsp" method="post">
            <label for="name">Name:</;label>
            <input type="text" id="name" name="name">
            <br><br>
            <label for="email">Email:</;label>
            <input type="text" id="email" name="email">
            <br><br>
            <label for="age">Age:</;label>
            <input type="number" id="age" name="age">
            <br><br>
            <input type="submit" value="Register User">
        </form>
    </body>
</html>