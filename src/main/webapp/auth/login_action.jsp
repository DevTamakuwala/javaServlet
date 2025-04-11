<html>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.LinkedHashMap" %>
<%!
    String username;
    String password;

    private static final Map<String, Double> PRODUCTS = new LinkedHashMap<>();

    static {
        PRODUCTS.put("Laptop", 75000.0);
        PRODUCTS.put("Smartphone", 25000.0);
        PRODUCTS.put("Headphones", 2000.0);
        PRODUCTS.put("Smartwatch", 5000.0);
    }
%>

<%
    username = request.getParameter("txtUname");
    password = request.getParameter("txtPassword");

    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "9016204659");

    PreparedStatement smt = con.prepareStatement("select * from user where username = ? and pass = ?");
    smt.setString(1, username);
    smt.setString(2, password);

    ResultSet rs = smt.executeQuery();

    if (rs.next()) {
        request.setAttribute("products", PRODUCTS);
        %>
           <jsp:forward page="../productSelection.jsp"/>
        <%
    } else {
        out.println("Wrong username and password");
        %>
            <jsp:include page="login_form.jsp"/>
        <%
    }
%>

</html>