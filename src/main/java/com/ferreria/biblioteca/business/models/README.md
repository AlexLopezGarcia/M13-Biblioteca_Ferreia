# **Model Package**

## Descripción
Contiene las entidades JPA que representan las tablas de la base de datos.

## Archivos principales
- **`User.java`**: Define los atributos de los usuarios.
- **`Book.java`**: Define los atributos de los libros.
- **`Loan.java`**: Define los atributos de los préstamos.

## Función
Mapear las tablas de la base de datos a objetos de Java para facilitar las operaciones de persistencia.

---
TENDRA:
@Entity
public class Book{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String isbn;

    Getter and setter
}