package cat.ferreria.api.presentation.restcontrollers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/public/bibliotecaferreria/i18n")
public class I18nController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/messages")
    public Map<String, String> getMessages(HttpServletRequest request) {
        Locale locale = RequestContextUtils.getLocale(request); // Obtiene el idioma de la cabecera Accept-Language
        Map<String, String> messages = new HashMap<>();

        // Lista de claves que quieres devolver
        String[] keys = {
                "libro.id", "libro.isbn", "libro.titulo", "libro.autor", "libro.categoria", "libro.estado",
                "app.title", "button.registrar.devolucion", "button.registrar.prestamo",
                "button.eliminar.libro", "button.modificar.libro", "button.anyadir.libro",
                "button.logarse", "button.registrar.usuario", "button.buscar", "button.recargar.lista",
                "alert.error", "alert.no.seleccionado", "alert.exito", "alert.completa.campos",
                "alert.cantidad.invalida", "alert.isbn.existe", "alert.cantidad.rango",
                "alert.cantidad.numero", "libro.editorial", "libro.cantidad",
                "alert.libro.anyadido", "alert.libro.noanyadido",
                "libro.estado.nuevo", "libro.estado.usado", "alert.libro.noeliminado",
                "alert.abrir.pantalla.libro", "alert.error.idioma",
                "alert.confirmacion", "alert.confirmar.eliminar", "alert.libro.seleccionado",
                "alert.id.invalido", "alert.seleccionar.libro", "alert.libro.eliminado",
                "alert.libro.noeliminado.historial", "alert.error.conexion",
                "button.si", "button.no"
                "alert.cantidad.numero", "label.registro", "label.dni", "label.nombre", "label.correo",
                "label.contrasena", "label.registrar.usuario", "button.modificar.usuario",
                "label.iniciar.sesion", "label.correo.sesion", "label.contrasena.sesion", "button.iniciar.sesion",
                "label.error", "label.olvidado","alert.inicio.sesion",
                "alert.registro.fallido", "alert.registro.exitoso", "alert.usuario.existe",
                "alert.usuario.duplicado", "alert.registro.error", "validacion.campos.vacios",
                "validacion.dni", "validacion.nombre", "validacion.correo", "validacion.contrasena",
                "button.editar.usuario", "button.eliminar.usuario", "checkbox.seleccionar.todos",
                "alert.seleccion.unica.titulo", "alert.seleccion.unica.cabecera",
                "alert.seleccion.unica.contenido", "alert.nada.seleccionado.titulo",
                "alert.nada.seleccionado.cabecera", "alert.nada.seleccionado.contenido",
                "alert.confirmar.eliminacion.titulo", "alert.confirmar.eliminacion.cabecera",
                "alert.confirmar.eliminacion.contenido", "alert.exito.eliminacion", "alert.error.modificar",
                "alert.exito.modificado", "alert.validacion.vacia", "alert.validacion.dni", "alert.validacion.nombre",
                "alert.validacion.correo", "alert.resultado.vacio", "label.columna.dni", "label.columna.nombre",
                "label.columna.correo"
        };

        // Obtener los mensajes traducidos
        for (String key : keys) {
            String message = messageSource.getMessage(key, null, locale);
            messages.put(key, message);
        }

        return messages;
    }
}