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
@RequestMapping("/bibliotecaferreria/i18n")
public class I18nController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/messages")
    public Map<String, String> getMessages(HttpServletRequest request) {
        Locale locale = RequestContextUtils.getLocale(request); // Obtiene el idioma de la cabecera Accept-Language
        Map<String, String> messages = new HashMap<>();

        // Lista de claves que quieres devolver
        String[] keys = {
                "libro.isbn", "libro.titulo", "libro.autor", "libro.categoria", "libro.estado",
                "app.title", "button.registrar.devolucion", "button.registrar.prestamo",
                "button.eliminar.libro", "button.modificar.libro", "button.anyadir.libro",
                "button.logarse", "button.registrar.usuario", "button.buscar", "button.recargar.lista",
                "alert.error", "alert.no.seleccionado", "alert.exito", "alert.completa.campos",
                "alert.cantidad.invalida", "alert.isbn.existe", "alert.cantidad.rango",
                "alert.cantidad.numero", "libro.editorial", "libro.cantidad",
                "alert.libro.anyadido", "alert.libro.noanyadido",
                "libro.estado.nuevo", "libro.estado.usado", "alert.libro.noeliminado",
                "alert.abrir.pantalla.libro", "alert.error.idioma"
        };

        // Obtener los mensajes traducidos
        for (String key : keys) {
            String message = messageSource.getMessage(key, null, locale);
            messages.put(key, message);
        }

        return messages;
    }
}