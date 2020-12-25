package com.payment.project.dto;

import lombok.Data;

@Data
public class TicketRequestDto {
    private Long routeNumber;
    private String departureTime;
}
