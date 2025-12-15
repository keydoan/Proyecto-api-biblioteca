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
}
