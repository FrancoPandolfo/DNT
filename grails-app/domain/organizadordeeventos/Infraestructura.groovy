package organizadordeeventos

class Infraestructura {

    Set<Item> infraestructura = []
    Buscador buscador


    def agregarInfraestructura(){
        Item infra = new Item()
        infraestructura.add(infra)
        return infra
    }

    def quitarInfraestructura(String nombre){
        Item infra = buscador.buscarInfraestructura(nombre,infraestructura)
        if(infra == null){throw new IllegalArgumentException("no se encontro infraestructura con ese nombre")}
        infraestructura.removeElement(infra)
        return infra
    }


    static hasMany=[
           infraestructura: Item
    ]
    static constraints = {
    }
}
