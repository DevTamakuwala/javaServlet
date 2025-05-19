package assignment3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CalculatorServlet")
public class q12 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Read and parse inputs
            int num1 = Integer.parseInt(request.getParameter("num1"));
            int num2 = Integer.parseInt(request.getParameter("num2"));

            // Perform operations
            int sum = num1 + num2;
            int product = num1 * num2;

            // Check division by zero
            if (num2 == 0) {
                throw new ArithmeticException("Division by zero is not allowed.");
            }
            double division = (double) num1 / num2;

            // Display results
            out.println("<html><body>");
            out.println("<h2>Calculation Results</h2>");
            out.println("<p>Addition: " + sum + "</p>");
            out.println("<p>Multiplication: " + product + "</p>");
            out.println("<p>Division: " + division + "</p>");
            out.println("</body></html>");

        } catch (Exception e) {
            // On error, forward to error page with message
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("assignment3/q12error.jsp").forward(request, response);
        }
    }
}

