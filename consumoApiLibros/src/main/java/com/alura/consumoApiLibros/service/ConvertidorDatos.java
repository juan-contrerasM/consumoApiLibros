package com.alura.consumoApiLibros.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ConvertidorDatos implements  IconvertidorDatos{
    private ObjectMapper objectMapper= new ObjectMapper();
    public ConvertidorDatos() {
        this.objectMapper = new ObjectMapper();
        // Registra el módulo JavaTimeModule para manejar tipos de fecha/hora Java 8
        this.objectMapper.registerModule(new JavaTimeModule());
    }
    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json,clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
