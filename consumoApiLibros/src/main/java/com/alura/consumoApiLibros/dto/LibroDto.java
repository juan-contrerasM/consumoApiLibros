package com.alura.consumoApiLibros.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroDto(
        @JsonAlias("title")String titulo,

       @JsonAlias("authors") List<AutoresDto>listaAutores,
        @JsonAlias("download_count")Double numeroDescargas,
        @JsonAlias("subjects")List<String> personajes,
        @JsonAlias("languages") List<String> idiomas
) {
}
