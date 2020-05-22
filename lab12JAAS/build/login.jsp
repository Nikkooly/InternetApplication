<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>FORM login</title>
</head>
<body>
<form method="post" action="j_security_check">
  <label>
    <input type="text" name="j_username"/>
  </label>
  <label>
    <input type="password" name="j_password"/>
  </label>
  <input type="submit"/>
</form>
</body>
</html>
