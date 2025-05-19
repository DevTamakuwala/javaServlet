package assignment3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/SupplierLogin")
public class SupplierLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("supplier_id");
        String pass = request.getParameter("supplier_password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/advancejava", "root", "9016204659");
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM supplier WHERE supplier_id=? AND supplier_password=?");
            ps.setString(1, id);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                request.setAttribute("supplierData", rs);
                request.getRequestDispatcher("assignment3/SupplierDashboard.jsp").forward(request, response);
            } else {
                response.sendRedirect("assignment3/login.jsp");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

