<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 30/7/2019
  Time: 20:28
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<!--<g:form action="agregar">-->
<html>
<head>
    <title></title>
</head>

<body>

<p>
<label for="presupuesto">ingrese su presupuesto:</label>
<input type="number" name="presupuesto" id="presupuesto"><br>
<br>
    <input type="submit" />
</p>

<a href="${createLink(uri:'mostrarEvento')}">ir al evento</a>

</body>
</html>
<!--</g:form>-->