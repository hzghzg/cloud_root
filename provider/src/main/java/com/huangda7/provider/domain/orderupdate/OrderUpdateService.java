package com.huangda7.provider.domain.orderupdate;

import com.huangda7.provider.application.dto.OrderUpdateDTO;
import com.huangda7.provider.domain.order.OrderBriefInfoDTO;
import com.huangda7.provider.infrastructure.util.BeanCopierUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderUpdateService {
    @Autowired
    OrderUpdateRepository orderUpdateRepository;
    public OrderUpdateDTO processOrderUpdate(Long orderId) {
//        saveOrderUpdateEntity(orderId);
        List<OrderUpdateEntity> orderUpdateEntities = orderUpdateRepository.findOrderUpdateEntitiesByOrderId(orderId);
        System.out.println(orderUpdateEntities);
        return null;
    }

    private void saveOrderUpdateEntity(Long orderId) {

    }

    public void insertRecord(OrderUpdateDTO orderUpdateDTO) {
        OrderUpdateEntity orderUpdateEntity = OrderUpdateEntity.builder()
                .orderId(orderUpdateDTO.getOrderId())
                .status(orderUpdateDTO.getOrderStatus())
                .build();
        orderUpdateRepository.save(orderUpdateEntity);
    }

    public void updateRecord(Long orderUpdateId) {
        OrderUpdateEntity orderUpdateEntity = OrderUpdateEntity.builder()
                .orderUpdateId(orderUpdateId)
                .orderId(10000000)
                .status("updated")
                .build();
        orderUpdateRepository.save(orderUpdateEntity);
    }
}
