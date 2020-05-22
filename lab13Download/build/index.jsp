<%@ page contentType="text/html" %>
<%@ page import="jspClasses.ChoiceXXX" %>
<%
  final String d = request.getServletContext().getInitParameter("dir");
  final ChoiceXXX ch = new ChoiceXXX(d, "docx");
  String ll = "";
  for (int i = 0; i < ch.listxxx.length; ++i) {
    ll = ch.listxxx[i];
%>
<br>
<a href="Aaa?file=<%=ll%>"><%=ll%>
</a>
<%}%>

<form method="POST" action="Bbb" enctype="multipart/form-data" >
  File:
  <input type="file" name="file" id="file" /> <br/>
  </br>
  <input type="submit" value="Upload" name="upload" id="upload" />
</form>
