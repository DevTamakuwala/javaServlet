<%@ page import="java.sql.ResultSet" %>

<%
    ResultSet rs = (ResultSet) request.getAttribute("supplierData");
    if(rs != null){
%>
<form action="<%=request.getContextPath()%>/UpdateSupplier" method="post">
    <input type="hidden" name="supplier_id" value="<%= rs.getString("supplier_id") %>">
    Name: <input type="text" name="supplier_name" value="<%= rs.getString("supplier_name") %>"><br>
    GST Number: <input type="text" name="gst_number" value="<%= rs.getString("gst_number") %>"><br>
    Quotation Number: <input type="text" name="quotation_number" value="<%= rs.getString("quotation_number") %>"><br>
    Purchase Order Number: <input type="text" name="purchase_order_number" value="<%= rs.getString("purchase_order_number") %>"><br>
    Payment Amount: <input type="text" name="payment_amount" value="<%= rs.getString("payment_amount") %>"><br>
    Order Status: <input type="text" name="order_status" value="<%= rs.getString("order_status") %>"><br>
    Payment Status: <input type="text" name="payment_status" value="<%= rs.getString("payment_status") %>"><br>
    <input type="submit" value="Update Supplier">
</form>
<% } %>
