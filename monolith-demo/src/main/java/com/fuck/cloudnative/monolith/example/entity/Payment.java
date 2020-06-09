package com.fuck.cloudnative.monolith.example.entity;

import com.fuck.cloudnative.monolith.example.entity.enumeration.PaymentStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
* DESCRIPTION:
*
* @author zouyan
* @create 2020/5/13-下午3:13
* created by fuck~
**/
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "payments")
public class Payment extends AbstractEntity {

    @Column(name = "payment_id")
    private String paymentId;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PaymentStatus status;

    @OneToOne
    @JoinColumn(unique = true)
    private Order order;

    public Payment(String paymentId, @NotNull PaymentStatus status, Order order) {
        this.paymentId = paymentId;
        this.status = status;
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Payment payment = (Payment) o;
        return Objects.equals(paymentId, payment.paymentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", status=" + status +
                ", order=" + order.getId() +
                '}';
    }
}
