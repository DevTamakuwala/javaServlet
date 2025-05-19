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
import java.sql.PreparedStatement;

@WebServlet("/save-student")
public class SaveStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/AdvanceJava", "root", "9016204659");

            // Insert query
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO students1 (id, name, email, course) VALUES (?, ?, ?, ?)");

            ps.setInt(1, Integer.parseInt(id));
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, course);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                out.println("<h3 style='color:green;'>Student details saved successfully.</h3>");
            } else {
                out.println("<h3 style='color:red;'>Failed to save student details.</h3>");
            }

            conn.close();
        } catch (Exception e) {
            out.println("<h3 style='color:red;'>Error: " + e.getMessage() + "</h3>");
        }

        out.println("<a href='studentForm'>Go Back</a>");
    }
}
