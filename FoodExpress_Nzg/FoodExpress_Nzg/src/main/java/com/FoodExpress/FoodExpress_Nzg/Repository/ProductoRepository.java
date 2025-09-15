package com.FoodExpress.FoodExpress_Nzg.Repository;

import com.FoodExpress.FoodExpress_Nzg.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Puedes agregar métodos personalizados si lo necesitas
}

