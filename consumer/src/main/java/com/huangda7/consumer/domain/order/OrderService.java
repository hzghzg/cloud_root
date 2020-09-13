package com.huangda7.consumer.domain.order;

import com.huangda7.consumer.application.TestService;
import com.huangda7.consumer.application.dto.OrderBriefInfoDTO;
import com.huangda7.consumer.application.event.GetOrderInfoEvent;
import com.huangda7.consumer.application.event.OutputEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    TestService testService;
    @Autowired
    OrderChannel orderChannel;
    @Autowired
    OrderProcessor orderProcessor;

    public void startGetOrderInfoProcess(GetOrderInfoEvent getOrderInfoEvent) {
        List<OrderBriefInfoDTO> orderBriefInfoDTOList = testService.getOrderBriefInfoFromProvider();
        OutputEvent outputEvent = OutputEvent.builder()
                .partitionKey("test_output_partition_key")
                .orderBriefInfoDTOList(orderBriefInfoDTOList)
                .build();
        orderProcessor.publishMessage(outputEvent);

    }

}
