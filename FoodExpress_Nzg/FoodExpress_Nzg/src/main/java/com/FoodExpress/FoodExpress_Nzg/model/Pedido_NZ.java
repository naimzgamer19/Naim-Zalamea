package com.FoodExpress.FoodExpress_Nzg.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Pedido_NZ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
    private String estado;

    @ManyToOne
    private Cliente_NZ cliente;

    @ManyToMany
    private List<Producto> productos;

    @ManyToOne
    private Repartidor_NZ repartidor;

    // Getters y setters
}
