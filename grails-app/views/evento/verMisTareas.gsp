<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'evento.label', default: 'Evento')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
      <table style=width:100%>
        <tr>
          <th>Tarea</th>
          <th>Estado</th>
        <g:each var="tarea" in="${tareas}">
          <tr>
            <td><g:link controlle="tarea" action="show" params="[id:tarea.id]">${tarea}</g:link></td>
            <td><g:link controlle="tarea" action="edit" params="[id:tarea.id]">editar</g:link></td>
            <td>
              <g:link controller: "tarea" action="tareaCompletada" params="[id:tarea.id]">Completada</g:link>
              <g:link controller: "tarea" action="tareaEnProcesoenProceso" params="[id:tarea.id]">En proceso</g:link>
              <g:link controller: "tarea" action="tareareiniciada" params="[id:tarea.id]">Reiniciar</g:link>
            <td><g:form method="DELETE">
              <input class="delete" type="submit" value="${message(code: 'default.button.delete.label'), default:'Delete'}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
            </g:form></td>
          </tr>
        </g:each>
      </table>
    <g:link controller= "tarea" action="create">Agregar Tarea</g:link>
    </body>
</html>
