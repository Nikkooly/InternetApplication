package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

import static jspClasses.Constants.*;

@WebFilter(Ccc_URL)
public class F2 implements Filter {
    @Override
    public void init(final FilterConfig filterConfig) {
        System.out.println("F2: init");
    }

    @Override
    public void doFilter(final ServletRequest req, final ServletResponse resp,
                         final FilterChain chain) throws IOException, ServletException {
        System.out.println("F2: doFilter");
        if (req.getParameter(VAL_1).equals("8") && req.getParameter(VAL_2).equals("8")
                && req.getParameter(VAL_3).equals("8")) {
            final RequestDispatcher res = req.getRequestDispatcher("/index.jsp");

            req.setAttribute("Blocking", "F2 blocked page");
            res.forward(req, resp);
        } else {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {
        System.out.println("F2: destroy");
    }
}
