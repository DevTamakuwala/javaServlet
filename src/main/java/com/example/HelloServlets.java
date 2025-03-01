package com.example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello-servlet")
public class HelloServlets extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public HelloServlets() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title> Servlet Hello servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> Servlet Hello servlet</h1>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}
