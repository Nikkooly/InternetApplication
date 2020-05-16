package servlets;

import jspClasses.Constants;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.String.format;
import static jspClasses.Constants.Bbb_URL;

@WebServlet(Bbb_URL)
public class Bbb extends HttpServlet {

    @Override
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
        final PrintWriter printWriter = resp.getWriter();

        resp.addHeader("Header1", Constants.HEADER_1);
        resp.addHeader("Header2", Constants.HEADER_2);

        printWriter.println(format("<html><body>Header1 = %s<br>Header2 = %s<br>Header3 = %s<br>Param1 = %s<br>" +
                "Param2 = %s<br>Param3 = %s<br>", req.getHeader(Constants.VAL_1), req.getHeader(Constants.VAL_2),
                req.getHeader(Constants.VAL_3), req.getParameter(Constants.VAL_1),
                req.getParameter(Constants.VAL_2), req.getParameter(Constants.VAL_3)));
    }
}
