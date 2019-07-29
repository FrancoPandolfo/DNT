<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'evento.label', default: 'Evento')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
      <table style=width:100%>
        <g:each var="nota" in="${notas}">
          <tr>
            <td><g:link controlle="nota" action="show" params="[id:nota.id]">${nota}</g:link></td>
            <td><g:link controlle="nota" action="edit" params="[id:nota.id]">editar</g:link></td>
            <td><g:form method="DELETE">
              <input class="delete" type="submit" value="${message(code: 'default.button.delete.label'), default:'Delete'}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
            </g:form></td>
          </tr>
        </g:each>
      </table>
    <g:link controller= "nota" action="create">Agregar Nota</g:link>
    </body>
</html>
