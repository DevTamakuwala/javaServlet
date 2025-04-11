<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
    <h2>Select Products</h2>
    <form action="<%=request.getContextPath()%>/CheckoutServlet" method="post">
        <%
            Map<String, Double> products = (Map<String, Double>) request.getAttribute("products");
            for (Map.Entry<String, Double> entry : products.entrySet()) {
        %>
            <input type="checkbox" name="products" value="<%= entry.getKey() %>">
            <%= entry.getKey() %> - ₹<%= entry.getValue() %> <br>
        <%
            }
        %>
        <br>
        <input type="submit" value="Checkout">
    </form>
</body>
</html>
