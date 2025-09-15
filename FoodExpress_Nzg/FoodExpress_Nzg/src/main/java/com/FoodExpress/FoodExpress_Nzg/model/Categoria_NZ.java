package com.FoodExpress.FoodExpress_Nzg.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Categoria_NZ {
    @Id @GeneratedValue
    private Long id;
    private String nombre;
}

