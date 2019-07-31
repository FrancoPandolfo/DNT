package organizadordeeventos

class UrlMappings {

    static mappings = {

        "/mostrarUsuarios"(controller: 'prueba4Controller')
        "/mostrarUsuarios"(controller: 'PruebaConEventoController')
        "/crearEvento"(controller: 'PruebaConEventoController')
        "/menu"(controller: 'PruebaConEventoController')
        "/mostrarEvento"(controller: 'PruebaConEventoController')

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
