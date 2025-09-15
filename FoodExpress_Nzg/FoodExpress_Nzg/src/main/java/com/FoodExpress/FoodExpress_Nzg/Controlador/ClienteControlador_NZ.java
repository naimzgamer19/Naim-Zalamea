package com.FoodExpress.FoodExpress_Nzg.Controlador;

import com.FoodExpress.FoodExpress_Nzg.model.Cliente_NZ; 
import com.FoodExpress.FoodExpress_Nzg.Servicio.ClienteServicio_NZ;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteControlador_NZ {

    private final ClienteServicio_NZ servicio;

    public ClienteControlador_NZ(ClienteServicio_NZ servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Cliente_NZ> listar() {
        return servicio.listarTodos();
    }

    @PostMapping
    public Cliente_NZ crear(@RequestBody Cliente_NZ cliente) {
        return servicio.guardar(cliente);
    }

    @GetMapping("/{id}")
    public Cliente_NZ obtener(@PathVariable Long id) {
        return servicio.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Cliente_NZ actualizar(@PathVariable Long id, @RequestBody Cliente_NZ nuevo) {
        return servicio.actualizar(id, nuevo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
    }
}
