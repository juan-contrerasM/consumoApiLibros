package com.alura.consumoApiLibros.service;

import com.alura.consumoApiLibros.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor,Long> {

    @Query("select autor  from Autor autor where  autor.fechaFallecimiento<:anio")
    List<Autor> obtenerAutoresVivosDeterminadoAnio(LocalDate anio);
}
