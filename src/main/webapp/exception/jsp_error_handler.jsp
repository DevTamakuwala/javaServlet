<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>

<html>
    <head>
        <title>Error Page</title>
    </head>
    <body>
        <h1>Error occurred</h1>
        <p>
            <%= exception.getMessage() %>
        </p>
    </body>
</html>