package servlets;

import jspClasses.CBean;
import jspClasses.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.function.Supplier;

import static jspClasses.Constants.*;

@WebServlet(Ccc_URL)
public class Ccc extends HttpServlet {

    @Override
    protected void service(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        final boolean useOld = req.getParameter(Constants.BEAN).equals("old");
        final HttpSession session = req.getSession();
        CBean bean = (CBean) session.getAttribute(BEAN);

        if (bean == null) {
            bean = new CBean();
        }

        bean = CBean.builder()
                .val1(getVal(req, bean::getVal1, VAL_1, useOld))
                .val2(getVal(req, bean::getVal2, VAL_2, useOld))
                .val3(getVal(req, bean::getVal3, VAL_3, useOld)).build();

        session.setAttribute(BEAN, bean);
        req.setAttribute(Constants.BEAN, bean);

        req.getRequestDispatcher("/jsp/ccc.jsp").forward(req, resp);
    }

    private String getVal(final HttpServletRequest req, final Supplier<String> supplier, final String name,
                          final boolean useOld) {
        final String param = req.getParameter(name);

        return useOld && (param == null || param.equals("")) ? supplier.get() : param;
    }
}
