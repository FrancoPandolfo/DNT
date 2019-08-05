<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="organizadordeeventos" />
        <g:set var="entityName" value="${message(code: 'usuario.label', default: 'Usuario')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-usuario" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
            </ul>
        </div>
        <div id="show-usuario" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <div class="items" width=100>
            <label>Username: <f:display bean="usuario" property="username"/></label><br>
            <label>Nombre: <f:display bean="usuario" property="nombre"/></label><br>
            <label>Apellido: <f:display bean="usuario" property="apellido"/></label><br>
            <label>Mail: <f:display bean="usuario" property="mail"/></label><br>
            <g:link controller="evento" action="create">Crear nuevo evento</g:link>
            </div>
            <g:form resource="${this.usuario}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.usuario}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
