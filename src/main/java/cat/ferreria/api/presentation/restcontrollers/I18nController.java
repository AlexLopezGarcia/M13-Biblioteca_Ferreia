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
        Locale locale = RequestContextUtils.getLocale(request) != null
                ? RequestContextUtils.getLocale(request)
                : Locale.forLanguageTag("es");
        Map<String, String> messages = new HashMap<>();

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
                "button.si", "button.no",
                "login.title", "login.header", "login.username", "login.password",
                "login.success", "login.error", "alert.login.cancelado",
                "alert.username.invalido", "alert.password.invalido"
        };

        for (String key : keys) {
            try {
                String message = messageSource.getMessage(key, null, locale);
                messages.put(key, message);
            } catch (Exception e) {
                messages.put(key, "Traducción no encontrada: " + key);
            }
        }

        return messages;
    }
}