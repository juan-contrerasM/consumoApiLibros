package com.alura.consumoApiLibros.principal;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    public Scanner teclado= new Scanner(System.in);
    public  int mostrarMenu(){
        System.out.println("""
                1. Buscar libro por titulo
                2. listar libros registrados
                3. listar autores registrados
                4. listar autores vivos en un determinado año 
                5. listar libros por idioma
                6. salir""");
       int opcion= Integer.parseInt(teclado.nextLine());
       return opcion;
    }

    public String preguntarNombreLibre(){

            System.out.println("""
                    Ingrese el nombre del libro""");
            return teclado.nextLine();


    }

    public LocalDate preguntarAnio() {
        System.out.println("""
               Ingrese el año en formato AAAA-MM-DD""");
        return LocalDate.parse(teclado.nextLine());
    }

    public String preguntarIdioma() {
        System.out.println("""
                Ingrese el idioma a buscar
                en -> ingles
                pr -> protugues
                es -> español""");
        return  teclado.nextLine();
    }
}
