package organizadordeeventos

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ProveedorController {

    ProveedorService proveedorService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond proveedorService.list(params), model:[proveedorCount: proveedorService.count()]
    }

    def show(Long id) {
        respond proveedorService.get(id)
    }

    def create() {
        respond new Proveedor(params)
    }

    def save(Proveedor proveedor) {
        if (proveedor == null) {
            notFound()
            return
        }

        try {
            proveedorService.save(proveedor)
        } catch (ValidationException e) {
            respond proveedor.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'proveedor.label', default: 'Proveedor'), proveedor.id])
                redirect proveedor
            }
            '*' { respond proveedor, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond proveedorService.get(id)
    }

    def update(Proveedor proveedor) {
        if (proveedor == null) {
            notFound()
            return
        }

        try {
            proveedorService.save(proveedor)
        } catch (ValidationException e) {
            respond proveedor.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'proveedor.label', default: 'Proveedor'), proveedor.id])
                redirect proveedor
            }
            '*'{ respond proveedor, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        proveedorService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'proveedor.label', default: 'Proveedor'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'proveedor.label', default: 'Proveedor'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
