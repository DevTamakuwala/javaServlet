package alltogether;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/login")
public class login_form extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();

        if(session.getAttribute("Username") != null){
            resp.sendRedirect("home-page");
        }

        String errorMessage = req.getParameter("error");

        out.println("<html><body>");
        if ("invalid".equals(errorMessage)) {
            out.println("<script>alert('Wrong Username or Password');</script>");
        }
        out.println("<h1>Login</h1>");
        out.println("<form action='login' method='post'>");
        out.println("<h3>Name: <input type='text' name='txtUname'><br></h3>");
        out.println("<h3>Password: <input type='password' name='txtPassword'><br></h3>");
        out.println("<input type='submit' value='Login'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("txtUname");
        String password = req.getParameter("txtPassword");

        resp.setContentType("text/html");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "9016204659");

            PreparedStatement smt = con.prepareStatement("select * from user where username = ? and pass = ?");
            smt.setString(1, name);
            smt.setString(2, password);

            ResultSet rs = smt.executeQuery();

            if (rs.next()) {
                HttpSession session = req.getSession();
                session.setAttribute("Username", name);
                session.setAttribute("Password", password);
                resp.sendRedirect("home-page"); // Redirect to a welcome page
            } else {
                resp.sendRedirect("login?error=invalid"); // Send error flag
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}