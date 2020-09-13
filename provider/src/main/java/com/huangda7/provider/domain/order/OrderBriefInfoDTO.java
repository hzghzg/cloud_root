package com.huangda7.provider.domain.order;

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
