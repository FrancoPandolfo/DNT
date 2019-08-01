<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 30/7/2019
  Time: 20:23
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<p>
    <br>
    <label for="presupuesto">ingrese su presupuesto:</label>
    <input type="number" name="presupuesto" id="presupuesto"><br>
    <br>
    <input type="submit" value="cargar presupuesto" />
</p>

<a href="${createLink(uri:'mostrarEvento')}">ir al evento</a>
</body>
</html>