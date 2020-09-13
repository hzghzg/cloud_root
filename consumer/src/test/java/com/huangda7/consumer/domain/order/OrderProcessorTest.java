package com.huangda7.consumer.domain.order;

import com.huangda7.consumer.application.event.GetOrderInfoEvent;
import com.huangda7.consumer.application.event.OutputEvent;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
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
    @Autowired
    OrderProcessor orderProcessor;
    @Autowired
    MessageCollector messageCollector;
    @Autowired
    private JacksonTester<OutputEvent> outputEventJacksonTester;
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


    @Test
    void should_publish_fail_checkpoint_event_when_sendFailCheckpointEvent_given_fail_checkpoint_event() throws IOException {
        //given
        OutputEvent outputEvent =  OutputEvent.builder()
                .partitionKey("test_output_partition_key")
                .build();
        //when
        orderProcessor.publishMessage(outputEvent);

        //then
        Message<String> outputMessage = (Message<String>) messageCollector
                .forChannel(orderChannel.testOutput()).poll();
        OutputEvent actualOutputEvent = outputEventJacksonTester.parse(outputMessage.getPayload()).getObject();

        assertAll(
                () -> assertThat(outputMessage.getHeaders().get("PARTITION_KEY")).isEqualTo("test_output_partition_key"),
                () -> assertThat(actualOutputEvent.getPartitionKey()).isEqualTo("test_output_partition_key"),
                () -> assertThat(actualOutputEvent).isEqualTo(outputEvent)
        );
    }
}