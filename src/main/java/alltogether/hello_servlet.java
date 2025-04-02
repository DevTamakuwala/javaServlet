package alltogether;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home-page")
public class hello_servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        HttpSession session = req.getSession();

        if(session.getAttribute("Username") == null){
            resp.sendRedirect("login");
        }

        PrintWriter out = resp.getWriter();

        out.println("<html><h1>Welcome To Java Servlet</h1>");
        out.println("<form action='home-page' method='post'>");
        out.println("<h3>Addition of two numbers: <input type='submit' value = 'Addition of two numbers' name='btnSubmit'></h3>");
        out.println("<input type='submit' value = 'Logout' name='btnSubmit'>");
        out.println("</form></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String button = req.getParameter("btnSubmit");

        HttpSession session = req.getSession();

        if(button.equalsIgnoreCase("logout")){
            session.invalidate();
            resp.sendRedirect("login");
        }

        if(button.equalsIgnoreCase("addition of two numbers")){
            resp.sendRedirect("sum-of-digits");
        }
    }
}
