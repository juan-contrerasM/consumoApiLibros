package com.alura.consumoApiLibros.controller;

import com.alura.consumoApiLibros.model.Libro;
import com.alura.consumoApiLibros.service.LibroRepository;

import java.util.List;

public class LibrosController {
    private LibroRepository libroRepository;

    public LibrosController(LibroRepository Librorepository) {
        this.libroRepository=Librorepository;
    }

    public Libro buscarLibroApi(Libro libro){
        return  libroRepository.save(libro);
    }
    public List<Libro>obtenerLibrosRegistrados(){
        return libroRepository.findAll();
    }

    public List<Libro> obtenerLibrosIdioma(String idioma) {
        return libroRepository.obtenerLibrosIdioma(idioma);
    }
}
