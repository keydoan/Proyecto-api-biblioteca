package com.example.api_biblioteca.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    return libroRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el libro con ID: " + id));
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

    @Transactional // O se guardan todos los libros de la lista, o no se guarda ninguno.
    public List<Libro> guardarEnLote(List<Libro> libros) {
        for (Libro libro : libros) { // Se procesan los libros enviados desde el Postman uno por uno
            
            // Validación anti-duplicados
            if (libroRepository.existsByTitulo(libro.getTitulo())) {
                throw new RuntimeException("Error en lote: Ya existe el título " + libro.getTitulo());
            }
            
            // Simulación de error "prohibido", si se escribe un libro con el titulo "ERROR" lanzará una excepción.
            if (libro.getTitulo().equalsIgnoreCase("ERROR")) {
                throw new RuntimeException("Valor prohibido detectado. Cancelando transacción.");
            }
            // Se guarda el libro si pasó las dos comprobacioness previas.
            libroRepository.save(libro);
        }
        return libros;
    }
}