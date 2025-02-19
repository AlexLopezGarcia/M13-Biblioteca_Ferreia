package com.bibliotecaFerreria.bussiness.model;

import lombok.*;

/**
 * @author alexl
 * @date 07/02/2025
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class LibroDTO {
    private String isbn;
    private String titulo;
    private String autor;
    private String categoria;
    private Integer cantidad;

    public static class LibroMapper {
        public static LibroDTO toDTO(Libro libro) {
            return new LibroDTO(
                    libro.getIsbn(),
                    libro.getTitulo(),
                    libro.getAutor(),
                    libro.getCategoria(),
                    libro.getCantidad()
            );
        }
    }
    }
