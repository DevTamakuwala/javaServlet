package assignment3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/SupplierList")
public class SupplierList extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>All Suppliers</h2><table border='1'>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "9016204659");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM supplier");
            out.println("<tr><th>ID</th><th>Name</th><th>GST</th><th>Order Status</th><th>Payment Status</th></tr>");
            while (rs.next()) {
                out.println("<tr><td>" + rs.getString("supplier_id") + "</td><td>" + rs.getString("supplier_name") + "</td><td>" +
                        rs.getString("gst_number") + "</td><td>" + rs.getString("order_status") + "</td><td>" +
                        rs.getString("payment_status") + "</td></tr>");
            }
            out.println("</table>");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

