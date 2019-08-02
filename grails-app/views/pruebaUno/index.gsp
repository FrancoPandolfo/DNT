<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 1/8/2019
  Time: 17:18
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>

<g:form>


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
        <input type="submit" />
    </p>


</g:form>
</body>
</html>