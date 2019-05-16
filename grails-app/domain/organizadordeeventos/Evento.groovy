package organizadordeeventos

class Evento {

    //los costos podrian estar todos dentro de una clase costos?
    InfoEvento info
    Set<Proveedor>proveedores=[]
    Integer costoTotalProveedores
    //puede que haya una funcionalidad de calendario que te de una lista de horarios o algo asi
    def cronograma = [:]
    //la primera lista va a contener la infraestructura, la segunda la cantidad de cada infraestructura,
    //la tercera el costo. uso lista de listas en lugar de map para poder agregar repetidos
    def infraestructura = [[],[],[]]
    Integer costoTotalInfraestructura
    Set<Transporte>transportes=[]
    //notas no va a poder ser una lista porque no puedo quitar una nota especifica
    //puede ser una sola nota o un map con la key que sea numero de nota
    Set<String> notas = []


    //falta hacer el constructor?

    //---estas funciones puede que vayan en otras clases---

    //ojo con funciones que devuelven null

    //esta funcion deberia tomar los datos que ingresa el admin y pasarselos a proveedor
    //o a otra clase para que llene un porveedor y dsp agregarlo al set
    def cargarProveedor(){
        //los datos se los puedo pasar por parametro a proveedor
        Proveedor proveedor = new Proveedor()
        proveedores.add(proveedor)
        proveedor.calcularCostoTotal()
        info.costoTotal += proveedor.costoTotal
        info.presupuestoRestante -= proveedor.costoTotal
    }

    def quitarProveedor(String name) {
        Proveedor proveedor = buscarProveedor(name)
        info.costoTotal -= proveedor.costoTotal
        info.presupuestoRestante += proveedor.costoTotal
        proveedores.removeElement(proveedor)
    }

    def buscarProveedor(String name){
        for(prov in proveedores ){
            if (prov.nombre == name) {
                return prov
            }
        }
        return null
    }



    //carga el presupuesto que ingresa el usuario
    def cargarPresupuesto(Integer presupuesto){
        info.presupuesto = presupuesto
    }


    //esta funcion inicializa el diccionario con las horas del dia
    //tambien podria ser que comienze vacio y se agregue dsp una actividad con su hora
    def InicializarCronograma(){

    }

    //esta funcion agrega una actividad al cronograma
    def cargarActividad(){

    }

    def quitarActividad(){

    }

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

    //esta funion deberia revisar si el elemento ya esta en la lista, si esta no lo agrega
    //y suma al contador en la posicion
    def agregarInfraestructura(infraestructura){

    }

    def quitarInfraestructura(){

    }

    def calcularTotalInfraestructura(){
        for (costo in infraestructura[2]) {
            costoTotalInfraestructura += costo
        }
    }

    //suma total del costo de todos los proveedores
    def calcularCostoTotalProveedores(){
        for (proveedor in proveedores){
            costoTotalProveedores += proveedor.costoTotal
        }
    }

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
        notas.add(nota)
    }

    def quitarNota(){

    }


    static hasMany=[
            proveedores:Proveedor,
            transportes:Transporte
    ]

    static constraints = {
    }
}

