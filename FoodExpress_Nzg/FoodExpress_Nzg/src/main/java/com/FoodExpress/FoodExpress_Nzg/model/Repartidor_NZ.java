package com.FoodExpress.FoodExpress_Nzg.model;

import java.util.List;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Repartidor_NZ {
    @Id @GeneratedValue
    private Long id;
    private String nombre;
    private String zona;
    private String telefono;

    @OneToMany(mappedBy = "repartidor")
    private List<Pedido_NZ> pedidos;
}
