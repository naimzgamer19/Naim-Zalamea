package com.FoodExpress.FoodExpress_Nzg.Servicio;

import com.FoodExpress.FoodExpress_Nzg.model.Producto;
import com.FoodExpress.FoodExpress_Nzg.Repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {

    private final ProductoRepository repo;

    public ProductoServicio(ProductoRepository repo) {
        this.repo = repo;
    }

    public List<Producto> listarTodos() {
        return repo.findAll();
    }

    public Producto guardar(Producto producto) {
        return repo.save(producto);
    }

    public Producto buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Producto actualizar(Long id, Producto nuevo) {
        Producto existente = buscarPorId(id);
        if (existente != null) {
            existente.setNombre(nuevo.getNombre());
            existente.setPrecio(nuevo.getPrecio());
            existente.setStock(nuevo.getStock());
            existente.setCategoria(nuevo.getCategoria());
            return repo.save(existente);
        }
        return null;
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
