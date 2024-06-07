package com.alura.consumoApiLibros.principal;

import com.alura.consumoApiLibros.controller.AuotesController;
import com.alura.consumoApiLibros.controller.LibrosController;
import com.alura.consumoApiLibros.dto.DatosDto;
import com.alura.consumoApiLibros.dto.LibroDto;
import com.alura.consumoApiLibros.model.Autor;
import com.alura.consumoApiLibros.model.Libro;
import com.alura.consumoApiLibros.service.AutorRepository;
import com.alura.consumoApiLibros.service.ConsumoApi;
import com.alura.consumoApiLibros.service.ConvertidorDatos;
import com.alura.consumoApiLibros.service.LibroRepository;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Principal {
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvertidorDatos convertidorDatos = new ConvertidorDatos();
    private String url = "https://gutendex.com/books/?page=2";
    private Menu menu = new Menu();
    private String nombreLibro = "";
    private LibrosController librosController;
    private LibroRepository libroRepository;
    private AuotesController auotesController;

    public Principal(LibroRepository libroRepository, AutorRepository autorRepository) {

        librosController = new LibrosController(libroRepository);
        auotesController = new AuotesController(autorRepository);
    }

    public void consumirApi() {
        //5 libros
        String json = consumoApi.obtenerDatos(url);
        var datosDto = convertidorDatos.obtenerDatos(json, DatosDto.class);
        int opcion = menu.mostrarMenu();

        while (opcion != 6) {

            switch (opcion) {
                case 1:
                    nombreLibro = menu.preguntarNombreLibre();
                    Optional<LibroDto> libroEncontrado = datosDto.libros().stream()
                            .filter(libroDto -> libroDto.titulo().equalsIgnoreCase(nombreLibro))
                            .findFirst();
                    if (libroEncontrado.isPresent()) {
                        LibroDto libroDto = libroEncontrado.get();
                        Libro libro = librosController.buscarLibroApi(
                                new Libro(
                                        libroDto.titulo(),
                                        libroDto.listaAutores().stream()
                                                .map(autoresDto -> new Autor(
                                                        autoresDto.nombre(),
                                                        autoresDto.fechaNaciemiento(),
                                                        autoresDto.fechafallecimiento()
                                                ))
                                                .collect(Collectors.toList()),  // Corrige el uso de map y collect
                                        libroDto.numeroDescargas(),
                                        libroDto.idiomas()
                                )
                        );
                        System.out.println(libro.getTitulo());

                    }else {
                        System.out.println("libro no encontrado");
                    }
                    break;
                case 2:
                    List<Libro> listaLibrosRegistrado = librosController.obtenerLibrosRegistrados();
                    listaLibrosRegistrado.stream()
                            .forEach(System.out::println);
                    break;
                case 3:
                    List<Autor> listaAutoresRegistrados = auotesController.listaAutores();
                    listaAutoresRegistrados.stream()
                            .forEach(System.out::println);
                    break;

                case 4:
                    LocalDate anio = menu.preguntarAnio();
                    List<Autor> listaAutores = auotesController.obtenerAutoresVivos(anio);
                    listaAutores.stream()
                            .forEach(System.out::println);
                    break;

                case 5:
                    String idioma =menu.preguntarIdioma();
                    List<Libro>listaLibros= librosController.obtenerLibrosIdioma(idioma);
                    listaLibros.stream()
                            .forEach(System.out::println);
                    break;
                default:
                    System.out.println("OPCION NO VALIDA");

            }
            // Volver a mostrar el menú después de cada operación
            opcion = menu.mostrarMenu();
        }
        System.out.println("¡Gracias por usar la aplicación!");
    }



}
