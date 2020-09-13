package com.huangda7.consumer.domain.order;

import com.huangda7.consumer.application.TestService;
import com.huangda7.consumer.application.event.GetOrderInfoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    TestService testService;
    public void startGetOrderInfoProcess(GetOrderInfoEvent getOrderInfoEvent) {
        testService.getOrderBriefInfoFromProvider();
    }
}
