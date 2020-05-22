import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class Xml extends HttpServlet {

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final int n = Integer.parseInt(req.getHeader(Constants.XRAND_N));
        final XRand xRand = new XRand(n);
        final String elements = xRand.get()
                .mapToObj(String::valueOf)
                .map(s -> format("<num>%s</num>", s))
                .collect(Collectors.joining(""));
        final String xmlRes = format("<?xml version=\"1.0\" encoding=\"utf-8\"?><rand>%s</rand>", elements);

        final PrintWriter writer = resp.getWriter();
        writer.println(xmlRes);
        writer.close();
    }
}
