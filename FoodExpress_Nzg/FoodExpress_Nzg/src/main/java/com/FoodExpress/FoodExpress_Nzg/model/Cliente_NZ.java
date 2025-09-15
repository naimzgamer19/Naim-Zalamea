package com.FoodExpress.FoodExpress_Nzg.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Cliente_NZ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String direccion;
    private String telefono;

    // Getters y setters
}

