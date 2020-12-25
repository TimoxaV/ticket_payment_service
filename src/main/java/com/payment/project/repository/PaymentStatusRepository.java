package com.payment.project.repository;

import com.payment.project.model.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentStatusRepository extends JpaRepository<PaymentStatus, Long> {
    PaymentStatus getPaymentStatusByStatusNameIs(PaymentStatus.StatusName statusName);
}
