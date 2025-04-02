package alltogether;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sum-of-digits")
public class sum_of_two_digits extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        HttpSession session = req.getSession();

        if (session.getAttribute("Username") == null) {
            resp.sendRedirect("login");
        }

        String answer = "";

        if (session.getAttribute("answer") != null) {
            answer = session.getAttribute("answer").toString();
            session.removeAttribute("answer");
        }


        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<h1>Addition of two numbers</h1>");
        out.println("<form action='sum-of-digits' method='post'>");
        out.println("<h3>Number 1: <input type='number' name='num1'></h3>");
        out.println("<h3>Number 2: <input type='number' name='num2'></h3>");
        if (!answer.isEmpty()) {
            out.println("The answer is: " + answer + "<br><br>");
        }
        out.println("<input type='submit' value = 'Add' name='btnSubmit'>");
        out.println("<input type='submit' value = 'Logout' name='btnSubmit'>");
        out.println("</form><body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String button = req.getParameter("btnSubmit");

        HttpSession session = req.getSession();

        if (button.equalsIgnoreCase("logout")) {
            session.invalidate();
            resp.sendRedirect("login");
        }

        if (button.equalsIgnoreCase("add")) {
            int num1 = Integer.parseInt(req.getParameter("num1"));
            int num2 = Integer.parseInt(req.getParameter("num2"));

            int answer = num1 + num2;

            session.setAttribute("answer", answer);

            resp.sendRedirect("sum-of-digits");
        }
    }
}
