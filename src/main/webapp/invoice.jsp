<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
    <title>Invoice</title>
</head>
<body>
    <h2>Invoice</h2>
    <table border="1">
        <tr>
            <th>Product</th>
            <th>Price (₹)</th>
        </tr>
        <%
            Map<String, Double> selectedItems = (Map<String, Double>) request.getAttribute("selectedItems");
            double total = (double) request.getAttribute("total");

            for (Map.Entry<String, Double> entry : selectedItems.entrySet()) {
        %>
        <tr>
            <td><%= entry.getKey() %></td>
            <td>₹<%= entry.getValue() %></td>
        </tr>
        <%
            }
        %>
        <tr>
            <td><strong>Total</strong></td>
            <td><strong>₹<%= total %></strong></td>
        </tr>
    </table>
</body>
</html>
