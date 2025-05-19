<html>
    <head>
        <title>Order JSPs</title>
    </head>
    <body>
        <form action='<%=request.getContextPath()%>/order-servlet' method="post">
            Product name: <input type="text" name="pname"><br><br>
            Quantity : <input type="number" name="qty"><br><br>
            Customer name: <input type="text" name="cname"><br><br>
            <input type="submit" name="btnSubmit" value="Submit">
        </form>
    </body>
</html>