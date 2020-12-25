package com.payment.project.service.impl;

import com.payment.project.model.PaymentStatus;
import com.payment.project.repository.PaymentStatusRepository;
import com.payment.project.service.PaymentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentStatusServiceImpl implements PaymentStatusService {
    private final PaymentStatusRepository paymentStatusRepository;

    @Autowired
    public PaymentStatusServiceImpl(PaymentStatusRepository paymentStatusRepository) {
        this.paymentStatusRepository = paymentStatusRepository;
    }

    @Override
    public PaymentStatus add(PaymentStatus paymentStatus) {
        return paymentStatusRepository.save(paymentStatus);
    }

    @Override
    public PaymentStatus getByName(String statusName) {
        return paymentStatusRepository.getPaymentStatusByStatusNameIs(PaymentStatus.StatusName
                .valueOf(statusName));
    }
}
