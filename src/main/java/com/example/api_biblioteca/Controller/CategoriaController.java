package com.example.api_biblioteca.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 1. IMPORTANTE: Importamos Categoria y CategoriaService, NO Autor
import com.example.api_biblioteca.Model.Categoria;
import com.example.api_biblioteca.Service.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService; // 2. Usamos el servicio de categorías

    @GetMapping
    public List<Categoria> listar() { // 3. Devolvemos una lista de Categorias
        return categoriaService.listarTodos();
    }

    @PostMapping
    public Categoria crear(@RequestBody Categoria categoria) { // 4. Recibimos y devolvemos una Categoria
        return categoriaService.guardar(categoria);
    }
}
