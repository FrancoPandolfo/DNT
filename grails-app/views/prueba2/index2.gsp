<g:form action="Eventos">
<p>
    <g:select
            name="evento"
            from="${eventos}"
            optionKey="id"
            optionValue="nombreDeUsuario"
            noSelection="['': '(elegí una opción)']"
    />
</p>

<p>
    <input type="submit" />
</p>


</g:form>