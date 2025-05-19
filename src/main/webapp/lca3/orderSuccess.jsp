<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    String pname = request.getParameter("pname");
    String cname = request.getParameter("cname");
    int qty = Integer.parseInt(request.getParameter("qty"));
%>

<html>
     <head>
         <title>Order JSPs</title>
     </head>
     <body>
         Product name: <h3><%=pname%></h3><br>
         Quantity : <h3><%=qty%></h3><br>
         Customer name: <h3><%=cname%></h3><br>
     </body>
 </html>