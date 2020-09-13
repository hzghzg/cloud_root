package com.huangda7.provider.domain.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @GetMapping(value = "/order-brief-info")
    public ResponseEntity<List<OrderBriefInfoDTO>> getOrderBriefInfo(@RequestParam("dateTime") String dateTime) throws InterruptedException {
//        Thread.sleep(6000);//for test load balance and retry
//        log.info("call provider");
        List<OrderBriefInfoDTO> orderBriefInfoDTOs = Collections.singletonList(OrderBriefInfoDTO.builder()
        .orderId(1000000004436176400L)
        .orderNum("9930448990222")
        .orderStatus("started")
        .build());
        return ResponseEntity.ok(orderBriefInfoDTOs);
    }
}
