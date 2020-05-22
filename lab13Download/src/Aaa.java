import jspClasses.ChoiceXXX;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class Aaa extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final String fileName = req.getParameter("file");
        final String dirName = getServletContext().getInitParameter("dir");
        final File file = new File(dirName, fileName);

        ChoiceXXX.outputDoc(file, resp);
    }
}
