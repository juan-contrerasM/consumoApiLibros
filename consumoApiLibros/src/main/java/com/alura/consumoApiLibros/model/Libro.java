package com.alura.consumoApiLibros.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString // ETIQUTAS LOOMBOK
//ETIQUTAS BASE DE DATOS
@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> listaAutores;
    private Double numeroDescargas;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "libro_idiomas", joinColumns = @JoinColumn(name = "libro_id"))
    @Column(name = "idioma")
    private List<String> tipoIdioma;

    public Libro( String titulo,List<Autor>listaAutores,Double numeroDescargas,List<String>tipoIdioma){
        this.titulo=titulo;
        this.listaAutores=listaAutores;
        this.numeroDescargas=numeroDescargas;
        this.tipoIdioma=tipoIdioma;
    }
}
