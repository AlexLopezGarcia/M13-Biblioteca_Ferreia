# **Controller Package**

## Descripción
Contiene los controladores REST que gestionan las peticiones HTTP. Estos controladores actúan como punto de entrada de la API para interactuar con la lógica de negocio.

## Archivos principales
- **`UserController.java`**: Controlador para gestionar usuarios (alta, baja, edición).
- **`BookController.java`**: Controlador para gestionar libros (consulta, creación, edición, eliminación).
- **`LoanController.java`**: Controlador para manejar préstamos y devoluciones.

## Función
Define los endpoints necesarios para realizar las operaciones de la biblioteca.

## Ejemplo
```java
@RestController
@RequestMapping("/api/users")
public class UserController {
    // Métodos HTTP
}

RECIBIRÁ DE LA PETICION HTTP UN DTO Y ENVIA AL SERVICE

