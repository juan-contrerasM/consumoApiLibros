package com.alura.consumoApiLibros.service;

import com.alura.consumoApiLibros.model.Autor;
import com.alura.consumoApiLibros.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LibroRepository extends JpaRepository<Libro,Long> {


    @Query("SELECT libro FROM Libro libro WHERE :idioma MEMBER OF libro.tipoIdioma")
    List<Libro> obtenerLibrosIdioma(String idioma);

}
