package com.payment.project.controllers;

import com.payment.project.dto.StatusResponseDto;
import com.payment.project.dto.TicketRequestDto;
import com.payment.project.dto.TicketResponseDto;
import com.payment.project.model.TicketRequest;
import com.payment.project.service.TicketRequestService;
import com.payment.project.service.mapper.TicketRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketRequestController {
    private final TicketRequestService ticketRequestService;
    private final TicketRequestMapper ticketRequestMapper;

    @Autowired
    public TicketRequestController(TicketRequestService ticketRequestService,
                                   TicketRequestMapper ticketRequestMapper) {
        this.ticketRequestService = ticketRequestService;
        this.ticketRequestMapper = ticketRequestMapper;
    }

    @PostMapping
    public TicketResponseDto addTicketRequest(@RequestBody TicketRequestDto ticketRequestDto) {
        TicketRequest ticketRequest = ticketRequestService.add(
                ticketRequestMapper.mapToTicketRequest(ticketRequestDto));
        return ticketRequestMapper.mapToTicketResponseDto(ticketRequest);
    }

    @GetMapping("/{id}")
    public StatusResponseDto getTicketRequestStatus(@PathVariable Long id) {
        TicketRequest ticketRequest = ticketRequestService.getById(id);
        return new StatusResponseDto(ticketRequest.getPaymentStatus().getStatusName().toString());
    }
}
