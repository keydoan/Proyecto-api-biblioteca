package com.example.api_biblioteca.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api_biblioteca.Model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    // Método de consulta para combinar atributos.
    public List<Autor> findByNombreAndNacionalidad (String nombre, String nacionalidad);
    
    // Crear método para verificar la existencia de un recurso.
    public Optional<Autor> findById(Long id);
    
}
