<%@ page import="jspClasses.CBean" %>
<%@ page import="jspClasses.Constants" %>

<html>
<body>
<%
  final CBean bean = (CBean) request.getAttribute(Constants.BEAN);
%>
<br> Val1 = <%=bean.getVal1()%>
<br> Val2 = <%=bean.getVal2()%>
<br> Val3 = <%=bean.getVal3()%>
<br><br><br>
<%
  final CBean bean2 = (CBean) session.getAttribute(Constants.BEAN);
%>
<br> Val1 = <%=bean2.getVal1()%>
<br> Val2 = <%=bean2.getVal2()%>
<br> Val3 = <%=bean2.getVal3()%>
</body>
</html>
