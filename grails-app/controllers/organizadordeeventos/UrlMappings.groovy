package organizadordeeventos

class UrlMappings {

    static mappings = {

        "/agregarAtributo"(controller: 'PruebaConEventoController')
        "/mostrarUsuarios"(controller: 'prueba4Controller')
        "/mostrarUsuarios"(controller: 'prueba3Controller')


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
