package com.example.api_biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api_biblioteca.Model.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    // Método para la validación anti-duplicados
    boolean existsByTitulo(String titulo);
}
