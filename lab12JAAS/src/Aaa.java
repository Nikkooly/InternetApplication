import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Aaa extends HttpServlet {

    @Override
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) {
        System.out.println("Servlet");
    }
}
