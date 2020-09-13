package com.huangda7.provider.domain.order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @GetMapping(value = "/order-brief-info")
    public ResponseEntity<List<OrderBriefInfoDTO>> getBLBriefInfo(@RequestParam("dateTime") String dateTime) {
        List<OrderBriefInfoDTO> orderBriefInfoDTOs = Collections.singletonList(OrderBriefInfoDTO.builder()
        .orderId(1000000004436176400L)
        .orderNum("9930448990222")
        .orderStatus("started")
        .build());
        return ResponseEntity.ok(orderBriefInfoDTOs);
    }
    @GetMapping
    public String getBLBriefInfo() {
        return "test";
    }

//    @GetMapping(value = "/bl-detail-info/{blId}")
//    public ResponseEntity<BLDetailInfoDTO> getBLDetailInfo(@PathVariable("blId") Long blId) {
//        BLDetailInfoDTO blDetailInfoDTO = BLDetailInfoDTO.builder()
//            .billOfLadingId(blId)
//            .billOfLadingNum("9930448990111")
//            .blStatus("Prepare in Progress")
//            .build();
//        return ResponseEntity.ok(blDetailInfoDTO);
//    }
}
