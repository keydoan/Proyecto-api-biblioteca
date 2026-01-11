package com.example.api_biblioteca.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.api_biblioteca.Model.Libro;
import com.example.api_biblioteca.Repository.LibroRepository;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> obtenerTodosLosLibros() {
        return libroRepository.findAll();
    }

    public Libro obtenerLibroPorId(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    public Libro guardarLibro(Libro libro) {
        // Comprobar si existe un libro con el mismo titulo.
        if (libroRepository.existsByTitulo(libro.getTitulo())) {
            // Si exite el libro, se lanza la excepción.
            throw new RuntimeException("Ya existe un libro con este titulo");
        }
        // Si no existe, se guarda el libro.
        return libroRepository.save(libro);
    }

    public Libro actualizarLibro(Long id, Libro libroActualizado) {
        Libro libroExistente = libroRepository.findById(id).orElse(null);

        if (libroExistente != null) {
            // Actualizamos los campos
            libroExistente.setTitulo(libroActualizado.getTitulo());
            libroExistente.setAutor(libroActualizado.getAutor());
            libroExistente.setCategoria(libroActualizado.getCategoria());

            // Guardar los cambios
            return libroRepository.save(libroExistente);
        } else {
            return null;
        }
    }

    // Borrar el libro
    public void borrarLibro(Long id) {
        libroRepository.deleteById(id);
    }
}