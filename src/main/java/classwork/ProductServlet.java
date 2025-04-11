package classwork;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Sample products (name -> price)
    private static final Map<String, Double> PRODUCTS = new LinkedHashMap<>();

    static {
        PRODUCTS.put("Laptop", 75000.0);
        PRODUCTS.put("Smartphone", 25000.0);
        PRODUCTS.put("Headphones", 2000.0);
        PRODUCTS.put("Smartwatch", 5000.0);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", PRODUCTS);
        RequestDispatcher dispatcher = request.getRequestDispatcher("productSelection.jsp");
        dispatcher.forward(request, response);
    }
}
