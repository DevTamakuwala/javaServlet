package servletWithDatabase;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/get-user-info")
public class getUserInfo extends HttpServlet {
    public getUserInfo() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();

        String name = "", email = "";
        if (session.getAttribute("Name") != null) {
            name = session.getAttribute("Name").toString();
            email = session.getAttribute("Email").toString();
        }


        out.println("<html>");
        out.println("<form action ='get-user-info' method='POST'>");
        out.println("Firstname:- <input type = 'text' name='firstname' placeholder='" + name + "'> <br><br>");
        out.println("Lastname:- <input type = 'text' name='lastname' placeholder='" + email + "'> <br><br>");
        out.println("<input type = 'submit' name='btnSubmit' value='Add Data'> <br>");
        out.println("<input type = 'submit' name='btnSubmit' value='Remove Session'> <br>");
        out.println("</form>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String buttonName = req.getParameter("btnSubmit");

        HttpSession session = req.getSession();

        System.out.println("buttonName " + buttonName);
//        int counter = (int) session.getAttribute("Counter");


//        System.out.println(counter);


        if(buttonName.equalsIgnoreCase("Add Data")){
            PrintWriter out = resp.getWriter();

            ResultSet rs;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "9016204659");

                PreparedStatement statement = con.prepareStatement("insert into tbluser (Firstname, Lastname) values(?, ?)");

                statement.setString(1, firstname);
                statement.setString(2, lastname);

                statement.executeUpdate();

                Statement statement1 = con.createStatement();

                rs = statement1.executeQuery("select * from tbluser");

                out.println("<html>");
                out.println("<table border='1'>");
                out.println("<tr>");
                out.println("<td>User Id</td>");
                out.println("<td>Firstname</td>");
                out.println("<td>Lastname</td>");
                out.println("</tr>");
                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>" + rs.getInt("userId") + "</td>");
                    out.println("<td>" + rs.getString("Firstname") + "</td>");
                    out.println("<td>" + rs.getString("Lastname") + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
                out.println("</html>");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (buttonName.equalsIgnoreCase("remove session")) {
            session.invalidate();
            doGet(req, resp);
        }
    }
}
