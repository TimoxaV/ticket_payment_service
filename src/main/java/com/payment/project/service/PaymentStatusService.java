package com.payment.project.service;

import com.payment.project.model.PaymentStatus;

public interface PaymentStatusService {
    PaymentStatus add(PaymentStatus paymentStatus);

    PaymentStatus getByName(String statusName);
}
