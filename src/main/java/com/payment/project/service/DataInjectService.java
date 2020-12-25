package com.payment.project.service;

import com.payment.project.model.PaymentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInjectService {
    private final PaymentStatusService paymentStatusService;

    @Autowired
    public DataInjectService(PaymentStatusService paymentStatusService) {
        this.paymentStatusService = paymentStatusService;
    }

    @PostConstruct
    private void injectData() {
        paymentStatusService.add(PaymentStatus.of("ERROR"));
        paymentStatusService.add(PaymentStatus.of("PROCESSING"));
        paymentStatusService.add(PaymentStatus.of("SUCCESS"));
    }
}
