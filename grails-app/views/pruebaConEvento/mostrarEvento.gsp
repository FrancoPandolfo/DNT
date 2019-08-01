<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 31/7/2019
  Time: 19:54
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<g:form action="mostrarPresupuesto">

    <p>
        <g:select
                name="evento"
                from="${eventos}"
                optionKey="id"
                optionValue="nombre"
                noSelection="['': '(elegí una opción)']"
        />
    </p>

    <p>
        <input type="submit" />
    </p>


</g:form>
</html>