package organizadordeeventos

class Evento {

    String nombre
    Set<Proveedor>proveedores=[]
    //puede que haya una funcionalidad de calendario que te de una lista de horarios o algo asi
    Cronograma cronograma
    Set<Tarea> tareas = []
    Dinero gastoTotal
    Presupuesto presupuesto
    Set<Usuario> usuarios = []
    Set<Administrador> administradores = []
    Set<Nota> notas = []

    Evento(String name){
        nombre = name
    }

    //esta funcion deberia tomar los datos que ingresa el admin y pasarselos a proveedor
    //o a otra clase para que llene un porveedor y dsp agregarlo al set
    def agregarProveedor(Proveedor proveedor){
        //los datos se los puedo pasar por parametro a proveedor
        proveedores.add(proveedor)
    }

    //agregue a la funcion los parametros de Item, ver Item!
    def agregarCompraAProveedor(Proveedor proveedor,String nombre, Integer cantidad, BigDecimal costo, Item.Tipo tipo){
        //Proveedor proveedor = buscarProveedor(nombre)
        //if(proveedor == null){throw new IllegalArgumentException("no se encontro proveedor con ese nombre")}
        //la compra la ingresa el usuario
        Item compra = new Item(nombre,cantidad,costo,tipo)
        proveedor.nuevaCompra(compra)
        calculoAgregarCompra(compra)
    }

    def quitarProveedor(Proveedor proveedor) {
        //Proveedor proveedor = buscador.buscarProveedor(name,proveedores)
        //if(proveedor == null){throw new IllegalArgumentException("no se encontro proveedor con ese nombre")}
        calculoQuitarProveedor(proveedor)
        proveedores.removeElement(proveedor)
    }


    //esta funcion agrega una actividad al cronograma el usuario tiene que ingresar los datos
    def agregarActividad(String nombre, String descripcion, Date inicio, Date fin){
        Actividad actividad = new Actividad(nombre,descripcion,inicio,fin)
        cronograma.agregarActividad(actividad)
    }

    def quitarActividad(Actividad actividad){
        cronograma.quitarActividad(actividad)
    }

    //los datos los carga el usuario
    def agregarTarea(String nombre,String descripcion){
        Tarea tarea = new Tarea(nombre,descripcion)
        tareas.add(tarea)
    }

    def tareaCompletada(Tarea tarea){
        //Tarea tarea = buscador.buscarTarea(nombre,tareas)
        //if(tarea == null){throw new IllegalArgumentException("no se encontro tarea con ese nombre")}
        tarea.completa()
    }

    def tareaEnProceso(Tarea tarea){
        //Tarea tarea = buscador.buscarTarea(nombre,tareas)
        //if(tarea == null){throw new IllegalArgumentException("no se encontro tarea con ese nombre")}
        tarea.enProceso()
    }

    def quitarTarea(Tarea tarea){
        //Tarea tarea = buscador.buscarTarea(nombre,tareas)
        //if(tarea == null){throw new IllegalArgumentException("no se encontro tarea con ese nombre")}
        tareas.removeElement(tarea)
    }

    def calculoAgregarCompra(Item compra){
        gastoTotal.plus(compra.costo)
        Dinero remanente = presupuesto.getRemanente()
        remanente.minus(compra.costo)
    }

    def calculoQuitarProveedor(Proveedor proveedor){
        gastoTotal.minus(proveedor.costoTotal)
        Dinero remanente = presupuesto.getRemanente()
        remanente.plus(proveedor.costoTotal)
    }

    def agregarNota(String titulo, String info){
        Nota nota = new Nota(titulo,info)
        notas.add(nota)
    }

    def quitarNota(Nota nota){
        notas.removeElement(nota)
    }

    /*
    //esta funion deberia revisar si el elemento ya esta en la lista, si esta no lo agrega
    //y suma al contador en la posicion
    //el usuario debe ingresar los datos del item de infraestructura
    def agregarInfraestructura(){
        Item infra = infraestructura.agregarInfraestructura()
        calculador.calculoAgregarInfraestructura(presupuesto,infra,gastoTotal)
    }

    def quitarInfraestructura(String nombre){
        Item infra = infraestructura.quitarInfraestructura(nombre)
        calculador.calculoQuitarInfraestructura(presupuesto,infra,gastoTotal)
    }
    */

    /*
   ////esta funcion deberia tomar los datos que ingresa el admin y pasarselos a transporta
   //o a otra clase para que llene un transporte y dsp agregarlo al set
   def cargarTransporte(nombre,detalles){
       Transporte transporte = new Transporte()
       transportes.add(transporte)
   }

   def quitarTransporte(String name){
       Transporte transporte = buscarTransporte(name)
       transportes.removeElement(transporte)
   }

   def buscarTransporte(String name){
       for(trans in transportes ){
           if (trans.nombre == name) {
               return trans
           }
       }
       return null
   }
   */


    /*
    //agrega un usuario a la lista de invitados del evento y aumento contador de invitados
    def agregarInvitado(Usuario invitado){
        info.invitados.add(invitado)
        info.cantidadInvitados++
    }

    //si el evento es privado?
    def quitarInvitado(String name){
        Usuario invitado = buscarInvitado(name)
        info.invitados.removeElement(invitado)
        info.cantidadInvitados--
    }

    def buscarInvitado(String name){
        for(inv in info.invitados ){
            if (inv.nombre == name) {
                return inv
            }
        }
        return null
    }

    */

    static hasMany=[
            proveedores:Proveedor,
            cronograma:Actividad,
            tareas:Tarea,
            usuarios:Usuario,
            administradores:Administrador,
            notas:Nota
    ]

    static constraints = {
      nombre blank: false, nullable: false
    }
}
