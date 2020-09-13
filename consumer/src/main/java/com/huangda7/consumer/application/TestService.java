package com.huangda7.consumer.application;

import com.huangda7.consumer.application.dto.OrderBriefInfoDTO;
import com.huangda7.consumer.application.dto.OrderUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class TestService {
    @Value("${provider.host}")
    private String providerHost;

    @Value("${provider.orderBriefInfoURL}")
    private String orderBriefInfoURL;

    @Value("${provider.testPostURL}")
    private String testPostURL;
    @Autowired
    RestTemplate restTemplate;
    public List<OrderBriefInfoDTO> getOrderBriefInfoFromProvider() {
        String dateTime = "test";
        String url = UriComponentsBuilder.newInstance()
                .scheme("http").queryParam("dateTime",dateTime).host(providerHost).path(orderBriefInfoURL).build()
//                .expand(dateTime)
                .toUriString();
//        String url = UriComponentsBuilder.fromHttpUrl(providerHost + orderBriefInfoURL)
//                .queryParam("dateTime", dateTime)
//                .build()
//                .toUriString();
        List<OrderBriefInfoDTO> orderBriefInfoDTOS = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<OrderBriefInfoDTO>>() {
        }).getBody();
        System.out.println(orderBriefInfoDTOS);
        return orderBriefInfoDTOS;
    }

    public void testPost() {
        String url = UriComponentsBuilder.newInstance()
                .scheme("http").host(providerHost).path(testPostURL).build()
//                .expand(dateTime)
                .toUriString();
        OrderUpdateDTO orderUpdateDTO = OrderUpdateDTO.builder()
                .orderId(1111111L)
                .orderNum("testfromconsumer")
                .orderStatus("started")
                .build();
        HttpEntity<OrderUpdateDTO> requestEntity = new HttpEntity<OrderUpdateDTO>(orderUpdateDTO, null);
//        String url = UriComponentsBuilder.fromHttpUrl(providerHost + orderBriefInfoURL)
//                .queryParam("dateTime", dateTime)
//                .build()
//                .toUriString();
        String result = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class).getBody();
        System.out.println(result);
    }
}
