package organizadordeeventos

import grails.gorm.transactions.Transactional

@Transactional
class PruebaUnoService {

  def crearEvento(Usuario usuario,String nombre) {
      usuario.crearEvento(nombre)
  }

  def eliminarEvento(Usuario usuario, Evento evento){
      usuario.quitarEvento(evento)
      evento.delete(flush: true)
  }

  def cargarProveedor(Usuario usuario,String nombre) {
      usuario.cargarProveedor(nombre)
  }

    def quitarProveedor(Usuario usuario,Proveedor proveedor) {
        usuario.quitarProveedor(proveedor)
        proveedor.delete(flush: true)
    }
}
