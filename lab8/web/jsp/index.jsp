<%@ page import="static jspClasses.Constants.*" %>

<html>
<body>
<form method="post" action="Aaa">
  <table>
    <tr>
      <td><label for="<%=VAL_1%>"><%=VAL_1%></label></td>
      <td><input id="<%=VAL_1%>" type="text" name="<%=VAL_1%>"></td>
    </tr>
    <tr>
      <td><label for="<%=VAL_2%>"><%=VAL_2%></label></td>
      <td><input id="<%=VAL_2%>" type="text" name="<%=VAL_2%>"></td>
    </tr>
    <tr>
      <td><label for="<%=VAL_3%>"><%=VAL_3%></label></td>
      <td><input id="<%=VAL_3%>" type="text" name="<%=VAL_3%>"></td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit" value="OK"></td>
    </tr>
  </table>
</form>
</body>
</html>
