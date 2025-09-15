package com.FoodExpress.FoodExpress_Nzg.Servicio;

import com.FoodExpress.FoodExpress_Nzg.model.Categoria_NZ;
import com.FoodExpress.FoodExpress_Nzg.Repository.CategoriaRepository_NZ;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServicio_Nz {

    private final CategoriaRepository_NZ repo;

    public CategoriaServicio_Nz(CategoriaRepository_NZ repo) {
    	this.repo = repo;
    }

    public List<Categoria_NZ> listarTodos() {
        return repo.findAll();
    }

    public Categoria_NZ guardar(Categoria_NZ categoria) {
        return repo.save(categoria);
    }

    public Categoria_NZ buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Categoria_NZ actualizar(Long id, Categoria_NZ nuevo) {
        Categoria_NZ existente = buscarPorId(id);
        if (existente != null) {
            existente.setNombre(nuevo.getNombre());
            return repo.save(existente);
        }
        return null;
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
