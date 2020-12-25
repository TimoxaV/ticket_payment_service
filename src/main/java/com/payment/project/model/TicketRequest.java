package com.payment.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Table(name = "ticket_requests")
@Data
public class TicketRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long routeNumber;
    private LocalDateTime departureTime;
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private PaymentStatus paymentStatus;
}
