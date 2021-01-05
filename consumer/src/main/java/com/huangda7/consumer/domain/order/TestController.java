package com.huangda7.consumer.domain.order;

import com.huangda7.consumer.application.TestService;
import com.huangda7.consumer.infrastructure.exception.CustomizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "*", maxAge = 1000L)
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

    @GetMapping("/getFromFrontEnd")
    public String getFromFrontEnd() throws Exception {
//        System.out.println("call from front end!");
        throw new CustomizeException();
//        return "success";
    }
}
