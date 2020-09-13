package com.huangda7.consumer.domain.order;

import com.huangda7.consumer.application.event.GetOrderInfoEvent;
import com.huangda7.consumer.application.event.OutputEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import static com.huangda7.consumer.domain.order.OrderConstant.GET_ORDER_INFO_INPUT;

@Component
@Slf4j
public class OrderProcessor {
    @Autowired
    OrderService orderService;

    @Autowired
    OrderChannel orderChannel;
//{
//    "partitionKey": "test_partitionKey"
//}
    @StreamListener(target = GET_ORDER_INFO_INPUT)
    public void processOrderEvent(GetOrderInfoEvent getOrderInfoEvent){
        log.info("Start process Event: {}",getOrderInfoEvent);
        orderService.startGetOrderInfoProcess(getOrderInfoEvent);
    }

    public void publishMessage(OutputEvent outputEvent) {
        orderChannel.testOutput().send(MessageBuilder.withPayload(outputEvent)
                .setHeader("PARTITION_KEY", outputEvent.getPartitionKey())
                .build());
    }
}
