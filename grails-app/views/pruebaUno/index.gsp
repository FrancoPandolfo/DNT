<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 1/8/2019
  Time: 17:18
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>

<g:form action="verEvento">


    <p>
        <g:select
                name="eventos"
                from="${eventos}"
                optionKey="id"
                optionValue="nombre"
                noSelection="['': '(elegí una opción)']"
        />
    </p>


    <p>
        <input type="submit" valued="ver Evento" />
    </p>


</g:form>

<g:form action="crearEvento">
    <button type="submit">crear nuevo evento</button>
</g:form>

</body>
</html>