package com.FoodExpress.FoodExpress_Nzg.Servicio;

import com.FoodExpress.FoodExpress_Nzg.model.Pedido_NZ;
import com.FoodExpress.FoodExpress_Nzg.Repository.PedidoRepository_NZ;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServicio_NZ {

    private final PedidoRepository_NZ repo;

    public PedidoServicio_NZ(PedidoRepository_NZ repo) {
        this.repo = repo;
    }

    public List<Pedido_NZ> listarTodos() {
        return repo.findAll();
    }

    public Pedido_NZ guardar(Pedido_NZ pedido) {
        return repo.save(pedido);
    }

    public Pedido_NZ buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Pedido_NZ actualizar(Long id, Pedido_NZ nuevo) {
        Pedido_NZ existente = buscarPorId(id);
        if (existente != null) {
            existente.setFecha(nuevo.getFecha());
            existente.setEstado(nuevo.getEstado());
            existente.setCliente(nuevo.getCliente());
            existente.setProductos(nuevo.getProductos());
            existente.setRepartidor(nuevo.getRepartidor());
            return repo.save(existente);
        }
        return null;
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
