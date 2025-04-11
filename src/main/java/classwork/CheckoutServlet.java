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

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final Map<String, Double> PRODUCTS = new LinkedHashMap<>();

    static {
        PRODUCTS.put("Laptop", 75000.0);
        PRODUCTS.put("Smartphone", 25000.0);
        PRODUCTS.put("Headphones", 2000.0);
        PRODUCTS.put("Smartwatch", 5000.0);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] selectedProducts = request.getParameterValues("products");

        double total = 0.0;
        Map<String, Double> selectedItems = new LinkedHashMap<>();

        if (selectedProducts != null) {
            for (String product : selectedProducts) {
                double price = PRODUCTS.get(product);
                selectedItems.put(product, price);
                total += price;
            }
        }

        request.setAttribute("selectedItems", selectedItems);
        request.setAttribute("total", total);

        RequestDispatcher dispatcher = request.getRequestDispatcher("invoice.jsp");
        dispatcher.forward(request, response);
    }
}
