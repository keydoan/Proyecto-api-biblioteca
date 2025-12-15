package com.example.api_biblioteca.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api_biblioteca.Model.Autor;
import com.example.api_biblioteca.Repository.AutorRepository;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    public Autor guardar(Autor autor) {
        return autorRepository.save(autor);
    }

    // Opcional: Buscar por ID
    public Autor buscarPorId(Long id) {
        return autorRepository.findById(id).orElse(null);
    }

    public Autor actualizar(Long id, Autor autorNuevo) {
        Autor autorExistente = autorRepository.findById(id).orElse(null);
        if (autorExistente != null) {
            autorExistente.setNombre(autorNuevo.getNombre());
            autorExistente.setNacionalidad(autorNuevo.getNacionalidad());
            return autorRepository.save(autorExistente);
        }
        return null;
    }

    public void borrar(Long id) {
        autorRepository.deleteById(id);
    }
}