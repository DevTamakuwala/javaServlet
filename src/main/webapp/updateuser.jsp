<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<body>

<h2>User Updated</h2>

<jsp:useBean id="myUser" class="bean.User" scope="session" />

<jsp:setProperty name="myUser" property="name" param="name" />

<jsp:setProperty name="myUser" property="email" param="email" />

<p>User details have been updated:</p>

<p>Name: <jsp:getProperty name="myUser" property="name" /></p>

<p>Email: <jsp:getProperty name="myUser" property="email" /></p>

<a href="userinfo.jsp">Back to User Info</a>

</body>