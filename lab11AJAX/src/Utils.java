import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.String.format;

public class Utils extends HttpServlet {

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final int x = Integer.parseInt(req.getHeader(Constants.VAL_1));
        final int y = Integer.parseInt(req.getHeader(Constants.VAL_2));

        resp.setHeader(Constants.VAL_3, String.valueOf(x + y));
    }
}
