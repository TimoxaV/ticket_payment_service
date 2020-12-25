package com.payment.project.repository;

import com.payment.project.model.TicketRequest;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRequestRepository extends JpaRepository<TicketRequest, Long> {
    @EntityGraph(attributePaths = {"paymentStatus"})
    TicketRequest getTicketRequestById(Long id);
}
