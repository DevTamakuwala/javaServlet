package lca3;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/order-servlet")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int qty = Integer.parseInt(req.getParameter("qty"));

        if (qty > 0) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/lca3/orderSuccess.jsp");
            dispatcher.forward(req, resp);
        } else if (qty <= 0) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/lca3/error.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
