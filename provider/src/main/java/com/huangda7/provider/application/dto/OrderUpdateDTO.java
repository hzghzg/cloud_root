package com.huangda7.provider.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderUpdateDTO {
    private Long orderId;
    private String orderNum;
    private String orderStatus;
}
