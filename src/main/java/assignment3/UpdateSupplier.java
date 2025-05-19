package assignment3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/UpdateSupplier")
public class UpdateSupplier extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("supplier_id");
        String name = request.getParameter("supplier_name");
        String gst = request.getParameter("gst_number");
        String quote = request.getParameter("quotation_number");
        String po = request.getParameter("purchase_order_number");
        double amount = Double.parseDouble(request.getParameter("payment_amount"));
        String orderStatus = request.getParameter("order_status");
        String paymentStatus = request.getParameter("payment_status");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "9016204659");

            String sql = "UPDATE supplier SET supplier_name=?, gst_number=?, quotation_number=?, purchase_order_number=?, payment_amount=?, order_status=?, payment_status=? WHERE supplier_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, gst);
            ps.setString(3, quote);
            ps.setString(4, po);
            ps.setDouble(5, amount);
            ps.setString(6, orderStatus);
            ps.setString(7, paymentStatus);
            ps.setString(8, id);
            ps.executeUpdate();

            response.sendRedirect("SupplierList");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
