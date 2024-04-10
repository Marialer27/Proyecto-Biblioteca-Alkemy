package com.miapp.biblioteca.ui;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;
import com.miapp.biblioteca.service.LibroServicio;
import com.miapp.biblioteca.service.UsuarioServicio;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Libro> biblioteca = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        LibroServicio libroService = new LibroServicio(biblioteca);
        UsuarioServicio usuarioService = new UsuarioServicio(usuarios);
        Scanner scanner = new Scanner(System.in);
        // Creo 3 libros
        libroService.crearLibro("El Señor de los Anillos", "J.R.R. Tolkien", "9788408203759", "Fantasía");
        libroService.crearLibro("Cien años de soledad", "Gabriel García Márquez", "9788420471839", "Realismo mágico");
        libroService.crearLibro("Harry Potter y la piedra filosofal", "J.K. Rowling", "9788478884457", "Fantasía");

        // Creo 3 usuarios
        usuarios.add(new Usuario("Juan", "001"));
        usuarios.add(new Usuario("María", "002"));
        usuarios.add(new Usuario("Pedro", "003"));

        int opcion;
        do {
            System.out.println("☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰");
            System.out.println("|❈❈❈❈❈❈❈❈ Bienvenido a la biblioteca virtual! ☺ ❈❈❈❈❈❈❈❈❈  |");
            System.out.println("|❈❈❈❈❈❈❈❈ Elija la operación que desea realizar ⊡❈❈❈❈❈❈❈❈❈  |");
            System.out.println("|     ❈❈❈❈Presione 1- Si desea crear un libro ✔❈❈❈❈             |");
            System.out.println("|     ❈❈❈❈Presione 2- Si desea actualizar un libro ✎❈❈❈❈       |");
            System.out.println("|     ❈❈❈❈Presione 3- Si desea buscar un libro por su ISBN❈❈❈❈  |");
            System.out.println("|     ❈❈❈❈Presione 4- Si desea buscar un libro por título❈❈❈❈   |");
            System.out.println("|     ❈❈❈❈Presione 5- Si desea listar los libros❈❈❈❈            |");
            System.out.println("|      ❈❈❈❈Presione 6- Si desea eliminar un libro ✂❈❈❈❈        |");
            System.out.println("| ❈❈❈❈Presione 7- Si desea solicitar un préstamo de un libro❈❈❈❈|");
            System.out.println("|❈❈❈❈Presione 8- Si desea realizar una devolución de un libro❈❈❈❈|");
            System.out.println("|❈❈❈❈❈❈❈❈ Presione 9- Si desea Salir del sistema ❈❈❈❈❈❈❈❈    |");
            System.out.println("☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese el ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Ingrese el género: ");
                    String genero = scanner.nextLine();
                    libroService.crearLibro(titulo, autor, isbn, genero);
                    System.out.println("Se agregó el libro con éxito");
                    break;
                case 2:
                    System.out.print("Ingrese el ISBN del libro a actualizar: ");
                    String isbnActualizar = scanner.nextLine();
                    System.out.print("Ingrese el nuevo título: ");
                    String nuevoTitulo = scanner.nextLine();
                    System.out.print("Ingrese el nuevo autor: ");
                    String nuevoAutor = scanner.nextLine();
                    System.out.print("Ingrese el nuevo género: ");
                    String nuevoGenero = scanner.nextLine();
                    libroService.actualizarLibro(isbnActualizar, nuevoTitulo, nuevoAutor, nuevoGenero);
                    System.out.print("El libro fue actualizado con éxito ");
                    break;
                case 3:
                    System.out.print("Ingrese el ISBN del libro a buscar: ");
                    String isbnBuscar = scanner.nextLine();
                    Libro libroISBN = libroService.buscarLibroPorISBN(isbnBuscar);
                    if (libroISBN != null) {
                        System.out.println("Libro encontrado: " + libroISBN.getTitulo());
                    } else {
                        System.out.println("Libro no encontrado");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el título a buscar: ");
                    String tituloBuscar = scanner.nextLine();
                    ArrayList<Libro> librosPorTitulo = libroService.buscarLibrosPorTitulo(tituloBuscar);
                    if (!librosPorTitulo.isEmpty()) {
                        System.out.println("Libros encontrados:");
                        for (Libro libro : librosPorTitulo) {
                            System.out.println(libro.getTitulo());
                        }
                    } else {
                        System.out.println("Ningún libro encontrado con ese título");
                    }
                    break;
                case 5:
                    ArrayList<Libro> listaLibros = libroService.obtenerTodosLosLibros();
                    for (Libro libro : listaLibros) {
                        System.out.println(libro.getTitulo() + " (" + libro.getISBN() + ")");
                    }
                    break;
                case 6:
                    System.out.print("Ingrese el ISBN del libro a eliminar: ");
                    String isbnEliminar = scanner.nextLine();
                    libroService.eliminarLibro(isbnEliminar);
                    System.out.print("El libro fue eliminado correctamente: ");
                    break;
                case 7:
                    System.out.print("Ingrese el número de identificación del usuario: ");
                    String idUsuario = scanner.nextLine();
                    Usuario usuarioPrestamo = usuarioService.buscarUsuarioPorId(idUsuario);
                    if (usuarioPrestamo != null) {
                        System.out.print("Ingrese el ISBN del libro a prestar: ");
                        String isbnPrestamo = scanner.nextLine();
                        Libro libroPrestamo = libroService.buscarLibroPorISBN(isbnPrestamo);
                        if (libroPrestamo != null) {
                            if (libroService.verificarDisponibilidad(libroPrestamo)) {
                                usuarioService.prestarLibro(usuarioPrestamo, libroPrestamo);
                                System.out.println("Préstamo existoso. Libro prestado a " + usuarioPrestamo.getNombre());
                            } else {
                                System.out.println("El libro no está disponible para préstamo.");
                            }
                        } else {
                            System.out.println("Libro no encontrado.");
                        }
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 8:
                    System.out.print("Ingrese el número de identificación del usuario: ");
                    String idUsuario1 = scanner.nextLine();
                    Usuario usuarioDevolucion = usuarioService.buscarUsuarioPorId(idUsuario1);
                    if (usuarioDevolucion != null) {
                        System.out.print("Ingrese el ISBN del libro a devolver: ");
                        String isbnDevolucion = scanner.nextLine();
                        Libro libroDevolucion = libroService.buscarLibroPorISBN(isbnDevolucion);
                        if (libroDevolucion != null) {
                            usuarioService.devolverLibro(usuarioDevolucion, libroDevolucion);
                            System.out.println("Devolución exitosa. Libro devuelto por " + usuarioDevolucion.getNombre());
                        } else {
                            System.out.println("Libro no encontrado");
                        }
                    } else {
                        System.out.println("Usuario no encontrado");
                    }
                    break;
                case 9:
                    System.out.println("Gracias por usar la Biblioteca Virtual. ¡Esperamos que regrese pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Las opciones disponibles son desde el 1 al 9. Muchas gracias!");
            }
        } while (opcion != 9);
    }
}
