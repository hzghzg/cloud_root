package com.huangda7.consumer.application.event;

import com.huangda7.consumer.application.dto.OrderBriefInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class OutputEvent {
    private String partitionKey;
    List<OrderBriefInfoDTO> orderBriefInfoDTOList;
}
