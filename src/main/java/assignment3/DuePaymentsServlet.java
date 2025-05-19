package assignment3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/DuePayments")
public class DuePaymentsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Suppliers with Due Payments (due to late delivery)</h2>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "9016204659");

            String query = "SELECT * FROM supplier WHERE payment_status='Due' AND order_status='Late'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                out.println("<p>" + rs.getString("supplier_id") + " - " + rs.getString("supplier_name") + "</p>");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

