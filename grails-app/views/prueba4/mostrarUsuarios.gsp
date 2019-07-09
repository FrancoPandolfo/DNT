<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 9/7/2019
  Time: 19:00
--%>

<%@ page contentType="text/html;charset=UTF-8" %>

<body>
<g:each in="${usuarios}" var="usuario" status="i">
    <h3>${i+1}. ${usuario.apellido}, ${usuario.nombre}</h3>
    <p>
        mail: ${usuario.mail}
    </p>
    <br/>
</g:each>
</body>