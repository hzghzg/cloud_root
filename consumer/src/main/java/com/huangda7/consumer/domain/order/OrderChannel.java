package com.huangda7.consumer.domain.order;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

import static com.huangda7.consumer.domain.order.OrderConstant.GET_ORDER_INFO_INPUT;

@Component
public interface OrderChannel {

    @Input(GET_ORDER_INFO_INPUT)
    SubscribableChannel getOrderInfoInput();
}
