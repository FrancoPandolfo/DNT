<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />



    %{--local assets--}%
    %<asset:stylesheet src="material.teal-amber.min.css"/>%
    <asset:javascript src="popper.min.js" />
    <asset:stylesheet src="application.css"/>


    <g:layoutHead/>
</head>
<body>

<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">

    <div class="mdl-layout__header mdl-layout__header--waterfall">
        <div class="mdl-layout__header-row">
            <a class="mdl-navigation__link" href="/#">
            <span class="mdl-layout-title">
                Organizador de eventos
            </span>
            </a>
            <!-- Add spacer, to align navigation to the right in desktop -->
            <div class="mdl-layout-spacer"></div>
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable mdl-textfield--floating-label mdl-textfield--align-right mdl-textfield--full-width">
            </div>
            <!-- Navigation -->
            %{--<div class="android-navigation-container">--}%
                <nav class="mdl-navigation">
                    <sec:ifLoggedIn>
                      <a class="mdl-navigation__link mdl-typography--text-uppercase" href="http://localhost:8080/home/miCuenta"><sec:username/></a>
                      <a class="mdl-navigation__link mdl-typography--text-uppercase" href="http://localhost:8080/logout">Cerrar sesión</a>
                    </sec:ifLoggedIn>
                    <sec:ifNotLoggedIn>
                    <a class="mdl-navigation__link mdl-typography--text-uppercase" href="http://localhost:8080/login/auth">Iniciar sesión</a>
                    <a class="mdl-navigation__link mdl-typography--text-uppercase" href="http://localhost:8080/usuario/create">Crear cuenta</a>
                    </sec:ifNotLoggedIn>
                </nav>
            %{--</div>--}%
        </div>
    </div>

    <div class="mdl-layout__content">
        <g:layoutBody/>
    </div>

    <footer class = "mdl-mini-footer">
        <div class = "mdl-mini-footer__left-section">

            <ul class = "mdl-mini-footer__link-list">
                <li><a href = "#">Contacto: augusjoaliza@gmail.com</a></li>
            </ul>
        </div>

    </footer>
</div>





</body>
</html>
