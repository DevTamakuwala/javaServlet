<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <h2 style="color:red;">An Error Occurred</h2>
    <p><%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "Unknown error occurred." %></p>
    <a href="assignment3/q12.jsp">Try Again</a>
</body>
</html>
