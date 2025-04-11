package jspwithjdbc;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/jsp-jdbc-registration")
public class registration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("jspwithjdbc/registration.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username;
        String password;

        username = request.getParameter("txtUsername");
        password = request.getParameter("txtPassword");

        Connection con;
        PreparedStatement smt;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "9016204659");
            smt = con.prepareStatement("insert into user values(0, ?, ?)");
            smt.setString(1, username);
            smt.setString(2, password);
            smt.executeUpdate();
            response.sendRedirect("jsp-jdbc-login");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
