import jspClasses.CBean;
import jspClasses.Constants;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Ccc extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        initContext();
    }

    private void initContext(){
        CBean cb = new CBean();
        ServletContext sc = getServletContext();
        sc.setAttribute("Value1",cb.getValue1());
        sc.setAttribute("Value2",cb.getValue2());
        sc.setAttribute("Value3",cb.getValue3());
        sc.setAttribute("artCBean", cb);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter pw = response.getWriter();
        HttpSession hs = request.getSession();
        String sId = hs.getId();
        CBean cb;

        if(request.getParameter("URLn").equals("old")){
            cb =(CBean)hs.getAttribute(sId);
        }else {
            cb = new CBean();
        }

        if(!request.getParameter("Value1").isEmpty()){
            cb.setValue1(request.getParameter("Value1"));
            hs.setAttribute("Value1",request.getParameter("Value1"));
            request.setAttribute("Value1",request.getParameter("Value1"));
        } else {
                cb.setValue1((String) hs.getAttribute("Value1"));
        }

        if(!request.getParameter("Value2").isEmpty()){
            cb.setValue2(request.getParameter("Value2"));
            hs.setAttribute("Value2",request.getParameter("Value2"));
            request.setAttribute("Value2",request.getParameter("Value2"));
        } else {
            cb.setValue2((String) hs.getAttribute("Value2"));
        }

        if(!request.getParameter("Value3").isEmpty()){
            cb.setValue3(request.getParameter("Value3"));
            hs.setAttribute("Value3",request.getParameter("Value3"));
            request.setAttribute("Value3",request.getParameter("Value3"));
        } else {
            cb.setValue3((String) hs.getAttribute("Value3"));
        }

        hs.setAttribute(sId,cb);
        request.setAttribute("Request_ref",cb);
        Enumeration en = hs.getAttributeNames();
        String x;

        if(hs.getAttribute(sId) == null){
            hs.setAttribute(sId,cb);
        }
        request.getRequestDispatcher("/jsp/Ccc.jsp").forward(request,response);
    }
}
