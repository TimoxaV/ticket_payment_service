package com.payment.project.service.mapper;

import com.payment.project.dto.TicketRequestDto;
import com.payment.project.dto.TicketResponseDto;
import com.payment.project.model.TicketRequest;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class TicketRequestMapper {
    public TicketRequest mapToTicketRequest(TicketRequestDto ticketRequestDto) {
        TicketRequest ticketRequest = new TicketRequest();
        ticketRequest.setDepartureTime(LocalDateTime.parse(ticketRequestDto.getDepartureTime()));
        ticketRequest.setRouteNumber(ticketRequestDto.getRouteNumber());
        return ticketRequest;
    }

    public TicketResponseDto mapToTicketResponseDto(TicketRequest ticketRequest) {
        TicketResponseDto ticketResponseDto = new TicketResponseDto();
        ticketResponseDto.setId(ticketRequest.getId());
        return ticketResponseDto;
    }
}
