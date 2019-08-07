<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 1/8/2019
  Time: 17:18
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>

<g:form controller="PruebaUnoEvento" action="index ">


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
        <button type="submit">ver evento</button>
    </p>


</g:form>

<g:form action="eliminarEvento">


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
        <button type="submit">eliminar evento</button>
    </p>


</g:form>

<g:form action="crearEvento">
    <button type="submit">crear nuevo evento</button>
</g:form>

<g:form action="cargarProveedor">
    <button type="submit">cargar nuevo proveedor</button>
</g:form>



</body>
</html>