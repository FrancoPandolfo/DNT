package organizadordeeventos

class Evento {

    InfoEvento info
    Set<Proveedor>proveedores=[]
    //puede que haya una funcionalidad de calendario que te de una lista de horarios o algo asi
    def cronograma = [:]
    //la primera lista va a contener la infraestructura, la segunda la cantidad de cada infraestructura
    def infraestructura = [[],[]]
    Set<Transporte>transportes=[]

    //---estas funciones puede que vayan en otras clases---

    //esta funcion deberia tomar los datos que ingresa el admin y pasarselos a proveedor
    //o a otra clase para que llene un porveedor y dsp agregarlo al set
    def cargarProveedor(){
        //los datos se los puedo pasar por parametro a proveedor
        Proveedor proveedor = new Proveedor()
        proveedores.add(proveedor)
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

    static hasMany=[
            proveedores:Proveedor
    ]

    static constraints = {
    }
}

