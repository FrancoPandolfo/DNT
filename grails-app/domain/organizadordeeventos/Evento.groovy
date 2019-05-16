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
    Set<String> notas = []


    //falta hacer el constructor?

    //---estas funciones puede que vayan en otras clases---

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

    ////esta funcion deberia tomar los datos que ingresa el admin y pasarselos a transporta
    //o a otra clase para que llene un transporte y dsp agregarlo al set
    def cargarTransporte(nombre,detalles){
        Transporte transporte = new Transporte()
        transportes.add(transporte)
    }

    //esta funion deberia revisar si el elemento ya esta en la lista, si esta no lo agrega
    //y suma al contador en la posicion
    def agregarInfraestructura(infraestructura){

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

    def agregarNota(String nota){
        notas.add(nota)
    }


    static hasMany=[
            proveedores:Proveedor,
            transportes:Transporte
    ]

    static constraints = {
    }
}

