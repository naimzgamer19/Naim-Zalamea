package com.FoodExpress.FoodExpress_Nzg.Repository;
import com.FoodExpress.FoodExpress_Nzg.model.Pedido_NZ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository_NZ extends JpaRepository<Pedido_NZ, Long> {
    // Puedes agregar métodos personalizados si lo necesitas
}
