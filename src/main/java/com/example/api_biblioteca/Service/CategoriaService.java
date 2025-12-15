package com.example.api_biblioteca.Service;

import com.example.api_biblioteca.Model.Categoria;
import com.example.api_biblioteca.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // 1. Método para obtener todas las categorías (para el GET)
    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }

    // 2. Método para guardar una nueva categoría (para el POST)
    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // 3. (Opcional) Método para buscar una por ID
    public Categoria obtenerPorId(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }
}