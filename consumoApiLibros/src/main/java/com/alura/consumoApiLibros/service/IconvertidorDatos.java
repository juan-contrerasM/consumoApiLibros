package com.alura.consumoApiLibros.service;

public interface IconvertidorDatos {
    //metodo geerico, duelve  cualquier cosa y resive cualquier clase
    <T> T  obtenerDatos(String json, Class<T> clase);
}
