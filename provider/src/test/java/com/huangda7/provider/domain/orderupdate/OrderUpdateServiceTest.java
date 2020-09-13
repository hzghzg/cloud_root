package com.huangda7.provider.domain.orderupdate;

import com.huangda7.provider.application.dto.OrderUpdateDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderUpdateServiceTest {
    @InjectMocks
    @Autowired
    OrderUpdateService orderUpdateService;
    @Mock
    OrderUpdateRepository orderUpdateRepository;

    @Captor
    ArgumentCaptor<OrderUpdateEntity> orderUpdateEntityArgumentCaptor;

    @Test
    void should_call_exist_bl_and_save_event_when_insertRecord_given_bl_id_and_not_exist_in_bl_update() {
        //given
        OrderUpdateDTO orderUpdateDTO = OrderUpdateDTO.builder()
                .orderId(1111L)
                .orderNum("test")
                .orderStatus("Processed")
                .build();
        when(orderUpdateRepository.save(any())).thenReturn(OrderUpdateEntity.builder().build());
        //when
        orderUpdateService.insertRecord(orderUpdateDTO);
        //then
        assertAll(
                () -> verify(orderUpdateRepository, times(1)).save(any()),
                () -> {
                    verify(orderUpdateRepository, times(1)).save(orderUpdateEntityArgumentCaptor.capture());
                    OrderUpdateEntity actualOrderUpdateEntity = orderUpdateEntityArgumentCaptor.getValue();
                    assertThat(actualOrderUpdateEntity.getOrderId()).isEqualTo(orderUpdateDTO.getOrderId());
                    assertThat(actualOrderUpdateEntity.getStatus()).isEqualTo(orderUpdateDTO.getOrderStatus());
                }
        );
    }

}