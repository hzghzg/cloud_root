package com.huangda7.provider.domain.orderupdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_update")
public class OrderUpdateEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_update_id")
    private long orderUpdateId;

    @Column(name = "order_id")
    private long orderId;

    @Column(name = "status")
    private String status;
}
