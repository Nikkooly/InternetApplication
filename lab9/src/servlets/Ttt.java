package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.String.format;
import static jspClasses.Constants.*;

@WebServlet(Ttt_URL)
public class Ttt extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
        final String urlParam = format("URL%s", req.getParameter(URL_N));
        final String initParam = req.getServletContext().getInitParameter(urlParam);

        if (initParam != null) {
            resp.sendRedirect(initParam);
        } else {
            final PrintWriter writer = resp.getWriter();

            writer.println(PARAMETER_URL_NOT_FOUND);
            writer.close();
        }
    }
}
