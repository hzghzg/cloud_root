package com.huangda7.provider.domain.orderupdate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@Import(AuditAwareImpl.class)
class OrderUpdateRepositoryTest {

    @Autowired
    OrderUpdateRepository orderUpdateRepository;

    @Test
    void should_return_expectOrderUpdateEntities_when_findOrderUpdateEntitiesByOrderId_given_order_id() {
        //given
        OrderUpdateEntity orderUpdateEntity = OrderUpdateEntity.builder()
                .orderId(1000000004436176400L)
                .status("Created")
                .build();
//        orderUpdateRepository.save(orderUpdateEntity);
        //when
        List<OrderUpdateEntity> expectOrderUpdateEntities = orderUpdateRepository.findOrderUpdateEntitiesByOrderId(1000000004436176400L);
        //then
        assertAll(
                () -> assertThat(expectOrderUpdateEntities.size()).isEqualTo(1),
                () -> assertThat(expectOrderUpdateEntities.get(0).getOrderId()).isEqualTo(orderUpdateEntity.getOrderId()),
                () -> assertThat(expectOrderUpdateEntities.get(0).getStatus()).isEqualTo(orderUpdateEntity.getStatus())
        );
    }


}