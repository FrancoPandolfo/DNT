package organizadordeeventos

class UrlMappings {

    static mappings = {

<<<<<<< HEAD
        //"/mostrarUsuarios"(controller: 'prueba4Controller')
=======
        "/mostrarUsuarios"(controller: 'prueba4Controller')
        "/mostrarUsuarios"(controller: 'PruebaConEventoController')
        "/crearEvento"(controller: 'PruebaConEventoController')
        "/menu"(controller: 'PruebaConEventoController')
        "/mostrarEvento"(controller: 'PruebaConEventoController')
>>>>>>> origin/master

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/"(controller: "home")
        //"/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
