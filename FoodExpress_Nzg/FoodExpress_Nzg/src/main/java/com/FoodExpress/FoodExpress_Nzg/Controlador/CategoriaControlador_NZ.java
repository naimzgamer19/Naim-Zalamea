package com.FoodExpress.FoodExpress_Nzg.Controlador;

import com.FoodExpress.FoodExpress_Nzg.model.Categoria_NZ;
import com.FoodExpress.FoodExpress_Nzg.Servicio.CategoriaServicio_Nz;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaControlador_NZ {

    private final CategoriaServicio_Nz servicio;

    public CategoriaControlador_NZ(CategoriaServicio_Nz servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Categoria_NZ> listar() {
        return servicio.listarTodos();
    }

    @PostMapping
    public Categoria_NZ crear(@RequestBody Categoria_NZ categoria) {
        return servicio.guardar(categoria);
    }

    @GetMapping("/{id}")
    public Categoria_NZ obtener(@PathVariable Long id) {
        return servicio.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Categoria_NZ actualizar(@PathVariable Long id, @RequestBody Categoria_NZ nuevo) {
        return servicio.actualizar(id, nuevo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
    }
}
