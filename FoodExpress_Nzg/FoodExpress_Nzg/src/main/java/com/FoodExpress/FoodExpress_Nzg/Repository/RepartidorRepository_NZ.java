package com.FoodExpress.FoodExpress_Nzg.Repository;

import com.FoodExpress.FoodExpress_Nzg.model.Repartidor_NZ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepartidorRepository_NZ extends JpaRepository<Repartidor_NZ, Long> {
    // Puedes agregar métodos personalizados si lo necesitas
}

