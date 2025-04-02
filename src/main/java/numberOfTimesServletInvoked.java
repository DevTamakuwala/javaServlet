import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/get-servlet")
public class numberOfTimesServletInvoked extends HttpServlet {
    public static int counter = 0;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        counter++;

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        session.setAttribute("Counter", counter);

        response.setContentType("text/html");

        out.println("<h2>"+counter+" times this page has been called till now.</h2>");
    }
}
