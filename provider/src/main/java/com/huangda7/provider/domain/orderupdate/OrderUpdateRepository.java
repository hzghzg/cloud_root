package com.huangda7.provider.domain.orderupdate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderUpdateRepository extends JpaRepository<OrderUpdateEntity, Long> {

    List<OrderUpdateEntity> findOrderUpdateEntitiesByOrderId(long orderId);

}
