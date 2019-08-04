package organizadordeeventos

import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class HomeController {

    LoginService loginService

    def index() {
        if (loginService.esUsuario(loggedIn, authenticatedUser)){
            redirect(controller: "usuario", action:"show")
        } else if(loginService.esAdmin(loggedIn, authenticatedUser)){
            render(view: "adminHome")
        }
    }

    def createUser(){ }

    @Secured(['ROLE_COMUN', 'ROLE_ADMIN'])
    def miCuenta(){
      if (loginService.esUsuario(loggedIn, authenticatedUser)) {
        redirect(controller: "usuario", action:"show")
      } else{
        redirect(action:"index")
      }
    }
}
