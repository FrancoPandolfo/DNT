
<g:form action="crearUnEvento">

  <!--
  <p>
    fecha: <input type="date" name="fecha" />
  </p>
  -->

  <p>
    <g:select
      name="usuario"
      from="${usuarios}"
      optionKey="id"
      optionValue="nombre"
      noSelection="['': '(elegí una opción)']"
      />
  </p>

  <p>
    <input type="submit" />
  </p>


</g:form>
