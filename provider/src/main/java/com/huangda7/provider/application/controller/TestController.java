package com.huangda7.provider.application.controller;

import com.huangda7.provider.application.dto.OrderUpdateDTO;
import com.huangda7.provider.domain.orderupdate.OrderUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    OrderUpdateService orderUpdateService;

    @PostMapping("/insert")
    public String insertRecord(@RequestBody OrderUpdateDTO orderUpdateDTO) {
        orderUpdateService.insertRecord(orderUpdateDTO);
        return "success";
    }

    @PostMapping("/update")
    public String updateRecord(@RequestBody String orderUpdateId) {
        orderUpdateService.updateRecord(Long.valueOf(orderUpdateId));
        return "success";
    }
}
