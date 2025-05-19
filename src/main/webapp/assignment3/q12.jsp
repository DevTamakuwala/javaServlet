<!DOCTYPE html>
<html>
<head>
    <title>Simple Calculator</title>
</head>
<body>
    <h2>Enter Two Numbers</h2>
    <form method="post" action="<%=request.getContextPath()%>/CalculatorServlet">
        Number 1: <input type="text" name="num1"><br><br>
        Number 2: <input type="text" name="num2"><br><br>
        <input type="submit" value="Calculate">
    </form>
</body>
</html>
