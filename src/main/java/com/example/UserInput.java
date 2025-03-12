package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UserInput")  // This is the URL pattern
public class UserInput extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public UserInput() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set content type to text/html
        response.setContentType("text/html");

        // Get PrintWriter to write the response
        PrintWriter out = response.getWriter();

        // Display an HTML form to accept user input
        out.println("<html><body>");
        out.println("<h1>Enter Your Details</h1>");
        out.println("<form action='UserInput' method='POST'>"); // This matches the @WebServlet annotation
        out.println("Name: <input type='text' name='name'><br>");
        out.println("Email: <input type='text' name='email'><br>");
        out.println("<input type='submit' value='Submit'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get name and email parameters from the request
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        // Set content type to text/html
        response.setContentType("text/html");

        // Get PrintWriter to write the response
        PrintWriter out = response.getWriter();

        // Display the submitted user details
        out.println("<html><body>");
        out.println("<h1>Received Information</h1>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("</body></html>");
    }
}
