package com.huangda7.consumer.domain.order;

import com.huangda7.consumer.application.event.GetOrderInfoEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.MessageBuilder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureJsonTesters
class OrderProcessorTest {

    @Autowired
    OrderChannel orderChannel;
    @MockBean
    OrderService orderService;
    @Test
    void should_receive_message_when_processOrderEvent_given_getOrderInfoEvent() {
        //given
        GetOrderInfoEvent getOrderInfoEvent = GetOrderInfoEvent.builder().partitionKey("test").build();
        //when
        SubscribableChannel channel = orderChannel.getOrderInfoInput();
        channel.send(MessageBuilder.withPayload(getOrderInfoEvent)
                .setHeader("partition_key", getOrderInfoEvent.getPartitionKey())
                .build());
        //then
        assertAll(
                () -> verify(orderService, times(1)).startGetOrderInfoProcess(any())
        );
    }
}