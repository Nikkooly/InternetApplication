<%@ page import="java.util.Collections" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="static java.lang.String.format" %>
<%@ page import="static jspClasses.Constants.*" %>

<html>
<body>
<form action="Ccc" method="post">
  <label><%=VAL_1%>
    <input type="text" width="15" name="<%= VAL_1%>">
  </label>
  <br>
  <label><%= VAL_1%>
    <input type="text" width="15" name="<%= VAL_2%>">
  </label>
  <br>
  <label><%= VAL_1%>
    <input type="text" width="15" name="<%= VAL_3%>">
  </label>
  <br>
  <label>old
    <input type="radio" name="<%= BEAN%>" value="old">
  </label>
  <label>new
    <input type="radio" name="<%= BEAN%>" value="new">
  </label>
  <input type="submit" name="press" value="Send Get" size="20">
</form>
</body>
</html>
