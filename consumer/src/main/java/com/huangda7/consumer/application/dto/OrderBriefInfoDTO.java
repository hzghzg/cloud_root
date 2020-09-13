package com.huangda7.consumer.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderBriefInfoDTO {
    private long orderId;
    private String orderNum;
    private String orderStatus;
}
