package organizadordeeventos

class UrlMappings {

    static mappings = {

        //"/mostrarUsuarios"(controller: 'prueba4Controller')

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
