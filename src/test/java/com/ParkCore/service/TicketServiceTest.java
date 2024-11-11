package com.ParkCore.service;

import com.ParkCore.model.Attraction;
import com.ParkCore.model.Ticket;
import com.ParkCore.model.Visitor;
import com.ParkCore.repository.AttractionRepository;
import com.ParkCore.repository.TicketRepository;
import com.ParkCore.repository.VisitorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TicketServiceTest {

    @Mock
    private TicketRepository ticketRepository;
    @Mock
    private VisitorRepository visitorRepository;
    @Mock
    private AttractionRepository attractionRepository;

    @InjectMocks
    private TicketService ticketService;

    @Test
    public void mustIssueTicket() {
        var visitor = new Visitor();
        visitor.setId(1L);

        var attraction = new Attraction();
        attraction.setId(1L);

        var ticketRequest = new Ticket();
        ticketRequest.setVisitor(visitor);
        ticketRequest.setAttraction(attraction);
        ticketRequest.setType("VIP");
        ticketRequest.setStatus("ACTIVE");
        ticketRequest.setVisitDate(new Date());

        when(visitorRepository.findById(1L)).thenReturn(Optional.of(visitor));
        when(attractionRepository.findById(1L)).thenReturn(Optional.of(attraction));

        var savedTicket = new Ticket();
        savedTicket.setCode("generated-code");
        savedTicket.setVisitor(visitor);
        savedTicket.setAttraction(attraction);
        savedTicket.setIssueDate(new Date());
        savedTicket.setType("VIP");
        savedTicket.setStatus("ACTIVE");
        savedTicket.setVisitDate(ticketRequest.getVisitDate());

        when(ticketRepository.save(any(Ticket.class))).thenReturn(savedTicket);

        var result = ticketService.issueTicket(ticketRequest);

        assertNotNull(result);
        assertEquals("generated-code", result.getCode());
        assertEquals(visitor, result.getVisitor());
        assertEquals(attraction, result.getAttraction());
        assertEquals("VIP", result.getType());
        assertEquals("ACTIVE", result.getStatus());
        assertEquals(ticketRequest.getVisitDate(), result.getVisitDate());

        verify(ticketRepository).save(any(Ticket.class));
    }


}
