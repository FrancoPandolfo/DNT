<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 6/7/2019
  Time: 17:43
--%>

<g:form>

    <p>
        <g:select
                name="usuario"
                from="${usuarios}"
                optionKey="id"
                optionValue="nombre"
                noSelection="['': '(elegí una opción)']"
        />
    </p>

    <!--
    <p>
        <input type="submit" />
    </p>
    -->


</g:form>