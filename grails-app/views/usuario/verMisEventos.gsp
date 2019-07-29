<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'usuario.label', default: 'Usuario')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
      <table style=width:100%>
        <g:each var="evento" in="${eventos}">
          <tr>
            <td><g:link controller="evento" action="show" params="[id:evento.id]">${evento}</g:link></td>
            <td><g:link controller="evento" action="edit" params="[id:evento.id]">editar</g:link></td>
            <td><g:form method="DELETE">
              <input class="delete" type="submit" value="${message(code: 'default.button.delete.label'), default:'Delete'}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
            </g:form></td>
          </tr>
        </g:each>
      </table>
    <g:link controller= "evento" action="create">Evento nuevo</g:link>
    </body>
</html>
