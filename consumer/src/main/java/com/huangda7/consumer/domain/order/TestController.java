package com.huangda7.consumer.domain.order;

import com.huangda7.consumer.application.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    TestService testService;
    @GetMapping
    public void getOrderBriefInfoFromProvider() {
        testService.getOrderBriefInfoFromProvider();
    }

    @GetMapping("/testpost")
    public void testPost() {
        testService.testPost();
    }
}
