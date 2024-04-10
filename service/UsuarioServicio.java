package com.miapp.biblioteca.service;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;

import java.util.ArrayList;

public class UsuarioServicio {
    private ArrayList<Usuario> usuarios;
    public UsuarioServicio(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void prestarLibro(Usuario usuario, Libro libro) {
        if (libro.isDisponible()) {
            usuario.getLibrosPrestados().add(libro);
            libro.setDisponible(false);
        } else {
            System.out.println("El libro no está disponible para préstamo.");
        }
    }
    public Usuario buscarUsuarioPorId(String id) {
        for (Usuario usuario : usuarios) {

            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    public void devolverLibro(Usuario usuario, Libro libro) {
        if (usuario.getLibrosPrestados().contains(libro)) {
            usuario.getLibrosPrestados().remove(libro);
            libro.setDisponible(true);
        } else {
            System.out.println("Este libro no fue prestado por este usuario.");
        }
    }
    public ArrayList<Libro> obtenerLibrosPrestados(Usuario usuario) {
        return usuario.getLibrosPrestados();
    }
}
