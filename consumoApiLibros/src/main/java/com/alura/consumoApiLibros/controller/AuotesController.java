package com.alura.consumoApiLibros.controller;

import com.alura.consumoApiLibros.model.Autor;
import com.alura.consumoApiLibros.service.AutorRepository;
import com.alura.consumoApiLibros.service.LibroRepository;

import java.time.LocalDate;
import java.util.List;

public class AuotesController {
    private AutorRepository autorRepository;

    public AuotesController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor>listaAutores(){
        return autorRepository.findAll();
    }


    public List<Autor> obtenerAutoresVivos(LocalDate anio) {
        return autorRepository.obtenerAutoresVivosDeterminadoAnio( anio);
    }
}
