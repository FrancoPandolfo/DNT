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
                name="evento"
                from="${eventos}"
                optionKey="id"
                optionValue="nombre"
                noSelection="['': '(elegí una opción)']"
        />
    </p>


    <p>
        <button type="submit" onclick="return confirm('¿Esta seguro?')" >eliminar evento</button>
    </p>


</g:form>

<g:form action="crearEvento">
    <button type="submit">crear nuevo evento</button>
</g:form>

<g:form action="cargarProveedor">
    <p>
        <g:select
                name="proveedor"
                from="${proveedores}"
                optionKey="id"
                optionValue="nombre"
                noSelection="['': '(elegí una opción)']"
        />
    </p>
    <button type="submit">cargar nuevo proveedor</button>
</g:form>

<g:form action="quitarProveedor">
    <p>
        <g:select
                name="proveedor"
                from="${proveedores}"
                optionKey="id"
                optionValue="nombre"
                noSelection="['': '(elegí una opción)']"
        />
    </p>
    <button type="submit">eliminar proveedor</button>
</g:form>

</body>
</html>