package organizadordeeventos

class LoginService {
  boolean esUsuario(boolean loggedIn, def authenticatedUsuario){
    if(loggedIn){
      Set<Role> roles = authenticatedUsuario.getAuthorities()
      return roles.contains(new Role(authority: 'ROLE_COMUN'))
    }
    false
  }

  boolean esAdmin(boolean loggedIn, def authenticatedUsuario){
    if(loggedIn){
      Set<Role> roles = authenticatedUsuario.getAuthorities()
      return roles.contains(new Role(authority: 'ROLE_ADMIN'))
    }
    false
  }
}
