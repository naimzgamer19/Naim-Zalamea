package com.FoodExpress.FoodExpress_Nzg.Controlador;

import com.FoodExpress.FoodExpress_Nzg.model.Pedido_NZ;
import com.FoodExpress.FoodExpress_Nzg.Servicio.PedidoServicio_NZ;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoControlador_NZ {

    private final PedidoServicio_NZ servicio;

    public PedidoControlador_NZ(PedidoServicio_NZ servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Pedido_NZ> listar() {
        return servicio.listarTodos();
    }

    @PostMapping
    public Pedido_NZ crear(@RequestBody Pedido_NZ pedido) {
        return servicio.guardar(pedido);
    }

    @GetMapping("/{id}")
    public Pedido_NZ obtener(@PathVariable Long id) {
        return servicio.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Pedido_NZ actualizar(@PathVariable Long id, @RequestBody Pedido_NZ nuevo) {
        return servicio.actualizar(id, nuevo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
    }
}

