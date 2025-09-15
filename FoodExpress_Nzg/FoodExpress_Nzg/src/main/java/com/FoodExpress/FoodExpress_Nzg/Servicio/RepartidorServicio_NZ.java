package com.FoodExpress.FoodExpress_Nzg.Servicio;

import com.FoodExpress.FoodExpress_Nzg.model.Repartidor_NZ;
import com.FoodExpress.FoodExpress_Nzg.Repository.RepartidorRepository_NZ;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepartidorServicio_NZ {

    private final RepartidorRepository_NZ repo;

    public RepartidorServicio_NZ(RepartidorRepository_NZ repo) {
        this.repo = repo;
    }

    public List<Repartidor_NZ> listarTodos() {
        return repo.findAll();
    }

    public Repartidor_NZ guardar(Repartidor_NZ repartidor) {
        return repo.save(repartidor);
    }

    public Repartidor_NZ buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Repartidor_NZ actualizar(Long id, Repartidor_NZ nuevo) {
        Repartidor_NZ existente = buscarPorId(id);
        if (existente != null) {
            existente.setNombre(nuevo.getNombre());
            existente.setZona(nuevo.getZona());
            existente.setTelefono(nuevo.getTelefono());
            return repo.save(existente);
        }
        return null;
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}

