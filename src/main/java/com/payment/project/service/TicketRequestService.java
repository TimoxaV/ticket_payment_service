package com.payment.project.service;

import com.payment.project.model.TicketRequest;

public interface TicketRequestService {
    TicketRequest add(TicketRequest ticketRequest);

    TicketRequest getById(Long id);
}
