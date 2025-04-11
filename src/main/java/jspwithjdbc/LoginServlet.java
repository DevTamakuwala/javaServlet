package jspwithjdbc;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/jsp-jdbc-login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String button = request.getParameter("btnSubmit");

        if (button.equalsIgnoreCase("login")) {
            String username;
            String password;

            username = request.getParameter("txtUsername");
            password = request.getParameter("txtPassword");

            Connection con;
            PreparedStatement smt;
            ResultSet rs;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "9016204659");
                smt = con.prepareStatement("select * from user where username = ? and pass = ?");
                smt.setString(1, username);
                smt.setString(2, password);
                rs = smt.executeQuery();
                while (rs.next()){
                    if (rs.getString(3).equals(password) && rs.getString(2).equals(username)) {
                        response.sendRedirect("jsp-jdbc-home-page");
                        return;
                    } else {
                        request.setAttribute("errorMessage", "Wrong username or password");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jspwithjdbc/login.jsp");
                        dispatcher.forward(request, response);
                        return;
                    }
                }
                request.setAttribute("errorMessage", "Wrong username or password");
                RequestDispatcher dispatcher = request.getRequestDispatcher("jspwithjdbc/login.jsp");
                dispatcher.forward(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (button.equalsIgnoreCase("register")) {
            response.sendRedirect("jsp-jdbc-registration");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("jspwithjdbc/login.jsp");
    }
}