package com.FoodExpress.FoodExpress_Nzg.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Producto {
    @Id @GeneratedValue
    private Long id;
    private String nombre;
    private Double precio;
    private Integer stock;

    @ManyToOne
    private Categoria_NZ categoria;
}

