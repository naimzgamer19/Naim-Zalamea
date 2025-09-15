package com.FoodExpress.FoodExpress_Nzg.Controlador;

import com.FoodExpress.FoodExpress_Nzg.model.Repartidor_NZ;
import com.FoodExpress.FoodExpress_Nzg.Servicio.RepartidorServicio_NZ;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repartidores")
public class RepartidorControlador_NZ {

    private final RepartidorServicio_NZ servicio;

    public RepartidorControlador_NZ(RepartidorServicio_NZ servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Repartidor_NZ> listar() {
        return servicio.listarTodos();
    }

    @PostMapping
    public Repartidor_NZ crear(@RequestBody Repartidor_NZ repartidor) {
        return servicio.guardar(repartidor);
    }

    @GetMapping("/{id}")
    public Repartidor_NZ obtener(@PathVariable Long id) {
        return servicio.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Repartidor_NZ actualizar(@PathVariable Long id, @RequestBody Repartidor_NZ nuevo) {
        return servicio.actualizar(id, nuevo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
    }
}


