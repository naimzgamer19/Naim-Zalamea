package com.FoodExpress.FoodExpress_Nzg.Repository;

import com.FoodExpress.FoodExpress_Nzg.model.Categoria_NZ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository_NZ extends JpaRepository<Categoria_NZ, Long> {
    // Puedes agregar métodos personalizados si lo necesitas
}

