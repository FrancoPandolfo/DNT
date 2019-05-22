package organizadordeeventos

class Evento {

    //los costos podrian estar todos dentro de una clase costos?
    String nombre
    Set<Proveedor>proveedores=[]
    //puede que haya una funcionalidad de calendario que te de una lista de horarios o algo asi
    Cronograma cronograma
    //la primera lista va a contener la infraestructura, la segunda la cantidad de cada infraestructura,
    //la tercera el costo. uso lista de listas en lugar de map para poder agregar repetidos
    Infraestructura infraestructura
    //notas no va a poder ser una lista porque no puedo quitar una nota especifica
    //puede ser una sola nota o un map con la key que sea numero de nota
    Set<Tarea> tareas = []
    Integer gastoTotal
    Presupuesto presupuesto
    CalculadorGastos calculador
    Buscador buscador


    //falta hacer el constructor?

    //esta funcion deberia tomar los datos que ingresa el admin y pasarselos a proveedor
    //o a otra clase para que llene un porveedor y dsp agregarlo al set
    def cargarProveedor(String nombre){
        //los datos se los puedo pasar por parametro a proveedor
        Proveedor proveedor = new Proveedor(nombre)
        proveedores.add(proveedor)
    }

    def agregarCompraAProveedor(String Nombre){
        Proveedor proveedor = buscarProveedor(nombre)
        if(proveedor == null){throw new IllegalArgumentException("no se encontro proveedor con ese nombre")}
        //la compra la ingresa el usuario
        Item compra = proveedor.nuevaCompra()
        calculador.calculoAgregarCompra(presupuesto,compra,gastoTotal)
    }

    def quitarProveedor(String name) {
        Proveedor proveedor = buscador.buscarProveedor(name,proveedores)
        if(proveedor == null){throw new IllegalArgumentException("no se encontro proveedor con ese nombre")}
        calculador.calculoQuitarProveedor(presupuesto,proveedor,gastoTotal)
        proveedores.removeElement(proveedor)
    }

    //carga el presupuesto que ingresa el usuario
    def cargarPresupuesto(Integer presupuesto){
        presupuesto.cargarPresupuesto()
    }


    //esta funcion agrega una actividad al cronograma el usuario tiene que ingresar los datos
    def agregarActividad(){
        cronograma.agregarActividad()
    }

    def quitarActividad(String nombre){
        cronograma.quitarActividad(nombre)
    }

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

    //los datos los carga el usuario
    def agregarTarea(){
        Tarea tarea = new Tarea()
        tareas.add(tarea)
    }

    def tareaCompletada(String nombre){
        Tarea tarea = buscador.buscarTarea(nombre,tareas)
        if(tarea == null){throw new IllegalArgumentException("no se encontro tarea con ese nombre")}
        tarea.completarse()
    }

    def quitarTarea(String nombre){
        Tarea tarea = buscador.buscarTarea(nombre,tareas)
        if(tarea == null){throw new IllegalArgumentException("no se encontro tarea con ese nombre")}
        tareas.removeElement(tarea)
    }

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

    def agregarNota(String nota){

    }

    def quitarNota(){

    }
    */

    static hasMany=[
            proveedores:Proveedor,
            cronograma:Actividad,
            tareas:Tarea
    ]

    static constraints = {
    }
}

