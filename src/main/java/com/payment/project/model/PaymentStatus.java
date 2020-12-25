package com.payment.project.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "statuses")
@Data
@NoArgsConstructor
public class PaymentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private StatusName statusName;

    public static PaymentStatus of(String statusName) {
        PaymentStatus paymentStatus = new PaymentStatus();
        paymentStatus.setStatusName(StatusName.valueOf(statusName));
        return  paymentStatus;
    }

    public enum StatusName {
        ERROR, SUCCESS, PROCESSING
    }
}
