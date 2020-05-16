package servlets;

import jspClasses.Constants;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;

import static java.lang.String.format;
import static jspClasses.Constants.Aaa_URL;

@WebServlet(Aaa_URL)
public class Aaa extends HttpServlet {

    @Override
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
        CloseableHttpResponse response = null;

        try {
            final URI uri = new URIBuilder()
                    .setScheme("http")
                    .setHost("172.16.193.69")
                    .setPort(8080)
                    .setPath("/AS_12YNS8/Bbb")
                    .setParameter(Constants.VAL_1, req.getParameter(Constants.VAL_1))
                    .setParameter(Constants.VAL_2, req.getParameter(Constants.VAL_2))
                    .setParameter(Constants.VAL_3, req.getParameter(Constants.VAL_3))
                    .build();

            final HttpPost post = new HttpPost(uri);
            post.setHeader(Constants.VAL_1, req.getParameter(Constants.VAL_1));
            post.setHeader(Constants.VAL_2, req.getParameter(Constants.VAL_2));
            post.setHeader(Constants.VAL_3, req.getParameter(Constants.VAL_3));

            final CloseableHttpClient client = HttpClients.createDefault();
            response = client.execute(post);

            client.close();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        final BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        final PrintWriter pw = resp.getWriter();
        final StringBuilder res = new StringBuilder();
        String part;

        while ((part = reader.readLine()) != null)
        {
            res.append(part);
        }
        reader.close();

        pw.println(format("<html><body>%s<br>%s<br>%s</body></html>",
                res.toString(), response.getFirstHeader("Header1"),
                response.getFirstHeader("Header2")));

        response.close();
        pw.close();
    }
}
