package com.example.api_biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api_biblioteca.Model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
