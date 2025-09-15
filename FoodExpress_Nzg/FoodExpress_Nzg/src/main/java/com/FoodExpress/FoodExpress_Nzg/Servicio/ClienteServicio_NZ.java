package com.FoodExpress.FoodExpress_Nzg.Servicio;

import com.FoodExpress.FoodExpress_Nzg.model.Cliente_NZ;
import com.FoodExpress.FoodExpress_Nzg.Repository.ClienteRepository_NZ;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio_NZ {
    private final ClienteRepository_NZ repo;

    public ClienteServicio_NZ(ClienteRepository_NZ repo) {
        this.repo = repo;
    }

    public List<Cliente_NZ> listarTodos() {
        return repo.findAll();
    }

    public Cliente_NZ guardar(Cliente_NZ cliente) {
        return repo.save(cliente);
    }

    public Cliente_NZ buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Cliente_NZ actualizar(Long id, Cliente_NZ nuevo) {
        Cliente_NZ existente = buscarPorId(id);
        if (existente != null) {
            existente.setNombre(nuevo.getNombre());
            existente.setEmail(nuevo.getEmail());
            existente.setDireccion(nuevo.getDireccion());
            existente.setTelefono(nuevo.getTelefono());
            return repo.save(existente);
        }
        return null;
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}

