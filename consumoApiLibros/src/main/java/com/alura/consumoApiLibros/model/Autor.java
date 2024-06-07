package com.alura.consumoApiLibros.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Getter @Setter @AllArgsConstructor @NoArgsConstructor  // ETIQUTAS LOOMBOK
//ETIQUTAS BASE DE DATOS
@Entity
@Table(name = "Autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private LocalDate fechaNacimiento;
    private LocalDate fechaFallecimiento;

    @ManyToMany(mappedBy = "listaAutores", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> listaLibros;

    public Autor (String nombre, LocalDate fechaNacimiento,LocalDate fechaFallecimiento){
        this.nombre=nombre;
        this.fechaNacimiento=fechaNacimiento;
        this.fechaFallecimiento=fechaFallecimiento;
    }

    public String toString(){

        return"nombre: "+ nombre+" Fecha nacimiento: "+ fechaNacimiento +" Fecha fallecimiento: "+fechaFallecimiento;
    }
}
