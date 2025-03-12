package com.example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SumOfNumbersServlet")
public class SumOfNumbersServlet extends HelloServlets {
    public SumOfNumbersServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        // Display an HTML form to accept user input
        out.println("<html><body>");
        out.println("<h1>Enter Your Details</h1>");
        out.println("<form action='SumOfNumbersServlet' method='POST'>"); // This matches the @WebServlet annotation
        out.println("Number 1: <input type='number' name='number1'><br>");
        out.println("Number 2: <input type='number' name='number2'><br>");
        out.println("Email: <input type='text' name='email'><br>");
        out.println("<input type='submit' value='Submit'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int num1 = Integer.parseInt(request.getParameter("number1"));
        int num2 = Integer.parseInt(request.getParameter("number2"));
        String email = request.getParameter("email");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<form>");
        out.println("<p> sum of " + num1 + " and " + num2 + " is: " + (num1 + num2) + "</p>");
        out.println("<p> Email: " + email + "</p>");
        out.println("</form>");
        out.println("</body></html>");
    }
}
