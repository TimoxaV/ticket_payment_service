package com.payment.project.controllers;

import com.payment.project.dto.StatusRequestDto;
import com.payment.project.model.PaymentStatus;
import com.payment.project.service.PaymentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/status")
public class PaymentStatusController {
    private final PaymentStatusService paymentStatusService;

    @Autowired
    public PaymentStatusController(PaymentStatusService paymentStatusService) {
        this.paymentStatusService = paymentStatusService;
    }

    @GetMapping("/get")
    public PaymentStatus getStatus(@RequestParam(name = "name") String statusName) {
        return paymentStatusService.getByName(statusName);
    }
}
