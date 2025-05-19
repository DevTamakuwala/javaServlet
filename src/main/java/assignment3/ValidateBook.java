package assignment3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ValidateBook")
public class ValidateBook extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Book Info</title></head><body>");
        out.println("<form method='post' action='ValidateBook'>");
        out.println("<fieldset style='width:300px'><legend><b>Book Information</b></legend>");
        out.println("Book-no: <input type='text' name='bookNo'><br><br>");
        out.println("Book-name: <input type='text' name='bookName'><br><br>");
        out.println("Price: <input type='text' name='price'><br><br>");
        out.println("<input type='submit' value='Validate'>");
        out.println("</fieldset></form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String bookNo = request.getParameter("bookNo");
        String bookName = request.getParameter("bookName");
        String price = request.getParameter("price");

        boolean hasError = false;
        StringBuilder errorMsg = new StringBuilder();

        // Validation
        if (bookNo == null || bookNo.trim().isEmpty() ||
                bookName == null || bookName.trim().isEmpty() ||
                price == null || price.trim().isEmpty()) {
            errorMsg.append("<p style='color:red;'>All fields are compulsory.</p>");
            hasError = true;
        }

        if (!bookNo.matches("\\d+")) {
            errorMsg.append("<p style='color:red;'>Book Number should be numeric.</p>");
            hasError = true;
        }

        if (!bookName.matches("[a-zA-Z\\s]+")) {
            errorMsg.append("<p style='color:red;'>Book Name should not contain special symbols.</p>");
            hasError = true;
        }

        out.println("<html><head><title>Validation Result</title></head><body>");

        if (hasError) {
            out.println("<h3>Validation Errors:</h3>");
            out.println(errorMsg.toString());
            out.println("<a href='ValidateBook'>Go Back</a>");
        } else {
            out.println("<h3 style='color:green;'>Book data validated successfully!</h3>");
            out.println("<p><b>Book No:</b> " + bookNo + "</p>");
            out.println("<p><b>Book Name:</b> " + bookName + "</p>");
            out.println("<p><b>Price:</b> " + price + "</p>");
            out.println("<a href='ValidateBook'>Add Another Book</a>");
        }

        out.println("</body></html>");
    }
}
