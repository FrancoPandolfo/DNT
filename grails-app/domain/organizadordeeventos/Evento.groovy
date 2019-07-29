package organizadordeeventos


class Evento {

    String nombre
    //por ahora locacion es un string
    String locacion
    Set<Proveedor>proveedores=[]
    //puede que haya una funcionalidad de calendario que te de una lista de horarios o algo asi
    Cronograma cronograma
    Set<Tarea> tareas = []
    Dinero gastoTotal
    Presupuesto presupuesto
    Set<Nota> notas = []
    Date fecha
    PosiblesFechas fechasPosibles = new PosiblesFechas()
    //Esto fijarse despues Set<Dinero> presupuestosPosibles = []

    Evento(String nombre){
        this.nombre = nombre
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
        Dinero remanente = presupuesto.getRemanente()
        if (remanente.compareTo(compra.costo) < 0){
            throw new IllegalArgumentException("compra superior al presupuesto actual")
        }
        proveedor.nuevaCompra(compra)
        calculoAgregarCompra(compra)
    }

    def eliminarCompra(Proveedor proveedor, Item compra){
        proveedor.eliminarCompra(compra)
        calculoEliminarCompra(compra)
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
        tarea.completar()
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


    //¿hay que encapsular total y remanente? ¿como hacemos?
    def calculoAgregarCompra(Item compra){
        //gastoTotal.plus(compra.costo)
        gastoTotal = gastoTotal + compra.getCosto()
        Dinero remanente = presupuesto.getRemanente()
        remanente = remanente + compra.getCosto()
        presupuesto.setRemanente(remanente)
    }

    def calculoQuitarProveedor(Proveedor proveedor){
        gastoTotal = gastoTotal - proveedor.getCostoTotal()
        Dinero remanente = presupuesto.getRemanente()
        remanente = remanente + proveedor.getCostoTotal()
        presupuesto.setRemanente(remanente)
    }

    def calculoEliminarCompra(Item compra){
        gastoTotal = gastoTotal - compra.getCosto()
        Dinero remanente = presupuesto.getRemanente()
        remanente = remanente + compra.getCosto()
        presupuesto.setRemanente(remanente)
    }

    def agregarNota(String titulo, String info){
        Nota nota = new Nota(titulo,info)
        notas.add(nota)
    }

    def quitarNota(Nota nota){
        notas.removeElement(nota)
    }

    //¿donde guardamos la propuesta?
    //las propuestas porahi es mejor que solo la puedan hacer los admins
    def proponerPresupuesto(BigDecimal presupuesto){
        Dinero propuesta = new Dinero(presupuesto)
        presupuestosPosibles.add(propuesta)
    }

    def quitarPresupuesto(Dinero propuesta){
        presupuestosPosibles.removeElement(propuesta)
    }

    def agregarPosibleFecha(Date date){
        fechasPosibles.agregarPosibleFecha(date)
    }

    def quitarPosibleFecha(Date date){
        fechasPosibles.quitarPosibleFecha(date)
    }



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
