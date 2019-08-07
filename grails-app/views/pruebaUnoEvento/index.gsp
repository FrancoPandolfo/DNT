<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 6/8/2019
  Time: 17:03
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<g:form action="cambiarNombre">
    <p>
        <br>
        <label for="nombre">Nombre:</label>
        <input type="text" name="nombre" id="nombre"><br>
    </p>
    <button type="submit">actualizar nombre de evento</button>
</g:form>

<g:form action="establecerFecha">
    <p>
        <br>
        <label for="fecha">Fecha:</label>
        <input type="date" name="fecha" id="fecha"><br>
    </p>
    <button type="submit">actualizar nombre de evento</button>
</g:form>

<g:form action="establecerLocacion">
    <p>
        <br>
        <label for="locacion">Lugar:</label>
        <input type="text" name="locacion" id="locacion"><br>
    </p>
    <button type="submit">actualizar locacion de evento</button>
</g:form>

<g:form action="establecerPresupuesto">
    <p>
        <br>
        <label for="presupuesto">monto:</label>
        <input type="number" name="presupuesto" id="presupuesto"><br>
    </p>
    <button type="submit">actualizar nombre de evento</button>
</g:form>

<g:form action="quitarNota">
    <p>
        <g:select
                name="notas"
                from="${notas}"
                optionKey="id"
                optionValue="nombre"
                noSelection="['': '(elegí una opción)']"
        />
    </p>
    <button type="submit">quitar nota del evento</button>
</g:form>


<g:form action="agregarNota">
    <p>
        <br>
        <label for="titulo">Titulo:</label>
        <input type="text" name="titulo" id="titulo"><br>
        <label for="info">Descripcion:</label>
        <input type="text" name="info" id="info"><br>
    </p>
    <button type="submit">agregar nota al evento</button>
</g:form>

<g:form action="agregarProveedor">
    <p>
        <g:select
                name="proveedores"
                from="${proveedores}"
                optionKey="id"
                optionValue="nombre"
                noSelection="['': '(elegí una opción)']"
        />
    </p>
    <button type="submit">agregar proveedor al evento</button>
</g:form>

<g:form action="quitarProveedor">
    <p>
        <g:select
                name="proveedores"
                from="${proveedores}"
                optionKey="id"
                optionValue="nombre"
                noSelection="['': '(elegí una opción)']"
        />
    </p>
    <button type="submit">quitar proveedor del evento</button>
</g:form>

<g:form action="agregarCompra">
    <p>
        <g:select
                name="proveedoresEvento"
                from="${proveedoresEvento}"
                optionKey="id"
                optionValue="nombre"
                noSelection="['': '(elegí una opción)']"
        />
    </p>
    <button type="submit">agregar una compra al proveedor</button>
</g:form>

<g:form action="quitarCompra">
    <p>
        <g:select
                name="proveedoresEvento"
                from="${proveedoresEvento}"
                optionKey="id"
                optionValue="nombre"
                noSelection="['': '(elegí una opción)']"
        />
    </p>
    <button type="submit">quitar una compra al proveedor</button>
</g:form>

<g:form action="quitarActividad">
    <p>
        <g:select
                name="actividades"
                from="${actividades}"
                optionKey="id"
                optionValue="nombre"
                noSelection="['': '(elegí una opción)']"
        />
    </p>
    <button type="submit">quitar actividad del evento</button>
</g:form>

<g:form action="agregarActividad">
    <button type="submit">agregar actividad al cronograma</button>
</g:form>

<g:form action="quitarTarea">
    <p>
        <g:select
                name="tareas"
                from="${tareas}"
                optionKey="id"
                optionValue="nombre"
                noSelection="['': '(elegí una opción)']"
        />
    </p>
    <button type="submit">quitartarea del evento</button>
</g:form>

<g:form action="agregarTarea">
    <button type="submit">agregar tarea</button>
</g:form>

<g:form action="proponerPresupuesto">
    <p>
        <br>
        <label for="presupuestoPropuesto">Monto:</label>
        <input type="number" name="presupuestoPropuesto" id="presupuestoPropuesto"><br>
    </p>
    <button type="submit">proponer presupuesto</button>
</g:form>

<g:form action="proponerFecha">
    <p>
        <br>
        <label for="fechaPropuesta">Fecha:</label>
        <input type="date" name="fechaPropuesta" id="fechaPropuesta"><br>
    </p>
    <button type="submit">proponer fecha</button>
</g:form>

</body>
</html>