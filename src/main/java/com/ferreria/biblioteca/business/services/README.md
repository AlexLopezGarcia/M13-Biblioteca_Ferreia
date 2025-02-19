# **Services Package**

## Descripción
Contiene la lógica de negocio del proyecto.

## Archivos principales
- **`UserService.java`**: Maneja las reglas de negocio relacionadas con usuarios.
- **`BookService.java`**: Maneja las reglas de negocio relacionadas con libros.
- **`LoanService.java`**: Maneja las reglas de negocio relacionadas con préstamos.
SERVICES : ACCESO A LA BASE DE DATOS
IMPL : MÉTODOS IMPLEMENTADOS PARA EL ACCESO A LA BD, UTILIZAN LOS REPOSITORIES
LOS SERVICES IMPLEMENTAN LA LÓGICA DE NEGOCIO, MANEJAN EXCEPCIONES, Y LA
INTERACCIO CON REPOSITORIES
## Función
Implementar la lógica empresarial que conecta los controladores con los repositorios.

RECIBE DEL CONTROLLER UN DTO, VERIFICA LO QUE TENGA QUE VERIFICAR Y HACE LO QUE TENGA
QUE HACER, DESPUÉS DEVOLVERÁ UN DTO AL CONTROLLER
---
