<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>lab10</title>
</head>
<br>
<h3>SELECT</h3>
<form action="connect">
  Name
  <br>
  <label>
    <input type="text" name="name"/>
  </label>
  <br>
  <input type="submit" name="find" value="find"/>
  <br>
</form>
<br>
<br>
<h3>Stored procedure</h3>
<form action="connect">
  First Name
  <br>
  <label>
    <input type="text" name="arg1"/>
  </label>
  <label>
    <input type="text" name="arg2"/>
  </label>
  <br>
  <input type="submit" name="command" value="command"/>
  <br>
</form>
</body>
</html>

