package com.huangda7.consumer;

import com.huangda7.consumer.domain.order.OrderChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableEurekaClient
@EnableBinding(OrderChannel.class)
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
