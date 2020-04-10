<%@ page import="jspClasses.CBean" %>
<%@ page import="jspClasses.Constants" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"
         import= "java.util.*" %>
<%@ page import="java.io.PrintWriter" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
   <%
    HttpSession hs = request.getSession();
    String sId = hs.getId();
    CBean cb = null ;
    Enumeration en = hs.getAttributeNames();
    String x;
    PrintWriter pw = response.getWriter();

    while (en.hasMoreElements()) {
        x = (String) en.nextElement();
        if(x.equals("Value1") || x.equals("Value2") || x.equals("Value3") || x.equals(sId)) {
            pw.println("<br />"+x + "= " + hs.getAttribute(x));
        }
    }
%>
<br>
<%
    String vatr1=(String)request.getAttribute("Value1");
    String vatr2=(String)request.getAttribute("Value2");
    String vatr3=(String)request.getAttribute("Value3");
    CBean obj=(CBean)request.getAttribute("Request_ref");
%>
<br>
<br> request_atr1=<%=vatr1%>
<br> request_atr2=<%=vatr2%>
<br> request_atr3=<%=vatr3%>
<br> request_ref=<%=obj%>
</body>
</html>
