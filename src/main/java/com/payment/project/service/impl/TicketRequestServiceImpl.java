package com.payment.project.service.impl;

import com.payment.project.model.PaymentStatus;
import com.payment.project.model.TicketRequest;
import com.payment.project.repository.PaymentStatusRepository;
import com.payment.project.repository.TicketRequestRepository;
import com.payment.project.service.TicketRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketRequestServiceImpl implements TicketRequestService {
    private static final String PROCESSING_STATUS = "PROCESSING";
    private final TicketRequestRepository ticketRequestRepository;
    private final PaymentStatusRepository paymentStatusRepository;

    @Autowired
    public TicketRequestServiceImpl(TicketRequestRepository ticketRequestRepository,
                                    PaymentStatusRepository paymentStatusRepository) {
        this.ticketRequestRepository = ticketRequestRepository;
        this.paymentStatusRepository = paymentStatusRepository;
    }

    @Override
    public TicketRequest add(TicketRequest ticketRequest) {
        PaymentStatus paymentStatus = paymentStatusRepository.getPaymentStatusByStatusNameIs(
                PaymentStatus.StatusName.valueOf(PROCESSING_STATUS));
        ticketRequest.setPaymentStatus(paymentStatus);
        return ticketRequestRepository.save(ticketRequest);
    }

    @Override
    public TicketRequest getById(Long id) {
        return ticketRequestRepository.getTicketRequestById(id);
    }
}
