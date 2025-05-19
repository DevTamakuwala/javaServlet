<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Form</title>
</head>
<body>
<h2>Enter Student Details</h2>
<form method="post" action="<%=request.getContextPath()%>/save-student">
    <label for="id">ID:</label>
    <input type="text" id="id" name="id" required><br><br>

    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>

    <label for="course">Course:</label>
    <input type="text" id="course" name="course" required><br><br>

    <input type="submit" value="Submit">
</form>
</body>
</html>
