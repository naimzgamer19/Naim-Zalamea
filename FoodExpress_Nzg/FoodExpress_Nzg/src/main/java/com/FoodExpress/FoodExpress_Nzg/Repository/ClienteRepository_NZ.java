package com.FoodExpress.FoodExpress_Nzg.Repository;

import com.FoodExpress.FoodExpress_Nzg.model.Cliente_NZ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository_NZ extends JpaRepository<Cliente_NZ, Long> {
    // Aquí puedes agregar métodos personalizados si los necesitas
}

