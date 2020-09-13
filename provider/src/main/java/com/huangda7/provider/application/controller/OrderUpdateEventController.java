package com.huangda7.provider.application.controller;

import com.huangda7.provider.application.dto.OrderUpdateDTO;
import com.huangda7.provider.domain.orderupdate.OrderUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-update")
public class OrderUpdateEventController {

    @Autowired
    OrderUpdateService orderUpdateService;


    @PostMapping
    public ResponseEntity<OrderUpdateDTO> blUpdate(@RequestBody String OrderId) {
        OrderUpdateDTO orderUpdateDTO = orderUpdateService.processOrderUpdate(Long.valueOf(OrderId));
        return ResponseEntity.ok(orderUpdateDTO);
    }

}
