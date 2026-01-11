package com.example.api_biblioteca.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_biblioteca.Model.Libro;
import com.example.api_biblioteca.Service.LibroService;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> listarLibros() {
        return libroService.obtenerTodosLosLibros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerUno(@PathVariable Long id) { // <?> permite que el método devuelva dos cosas
                                                                 // totalmente distintas.
        try {
            Libro libro = libroService.obtenerLibroPorId(id);
            return ResponseEntity.ok(libro);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // Si no existe, devuelve 404
        }
    }

    @PostMapping
    public Libro crear(@RequestBody Libro libro) {
        return libroService.guardarLibro(libro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Libro libro) {
        try {
            Libro actualizado = libroService.actualizarLibro(id, libro);
            return ResponseEntity.ok(actualizado); // Retorna el objeto libro.
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // Devuelve 404 si el ID no existe
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id) {
        try {
            libroService.borrarLibro(id);
            return ResponseEntity.noContent().build(); // Devuelve 204 si se borra con éxito
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // Devuelve 404 si el ID no existe
        }
    }

    @PostMapping("/lote") // Endpoint para operación en lote
    public List<Libro> crearEnLote(@RequestBody List<Libro> libros) {
        return libroService.guardarEnLote(libros);
    }

    // comentario para probar add en el git
}
