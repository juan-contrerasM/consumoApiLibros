package com.alura.consumoApiLibros.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;


@JsonIgnoreProperties(ignoreUnknown = true)
public record AutoresDto(
        @JsonAlias("name")String nombre,
        @JsonAlias("birth_year")LocalDate fechaNaciemiento,
        @JsonAlias("death_year")LocalDate fechafallecimiento
) {
}

