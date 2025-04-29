package cat.ferreria.api.bussiness.model.clazz;

import jakarta.persistence.*;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long libroId;

    private String isbn;
    private String titulo;
    private String autor;
    private String categoria;

    @Column(name = "estado_uso")
    private Boolean estadoUso;

    @ManyToOne
    @JoinColumn(name = "estante_id")
    private Estante estante;

    public Long getLibroId() {
        return libroId;
    }

    public void setLibroId(Long libroId) {
        this.libroId = libroId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Boolean getEstadoUso() {
        return estadoUso;
    }

    public void setEstadoUso(Boolean estadoUso) {
        this.estadoUso = estadoUso;
    }

    public Estante getEstante() {
        return estante;
    }

    public void setEstante(Estante estante) {
        this.estante = estante;
    }
}