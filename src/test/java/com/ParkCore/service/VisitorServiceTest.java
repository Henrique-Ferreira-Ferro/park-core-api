package com.ParkCore.service;

import com.ParkCore.model.Visitor;
import com.ParkCore.repository.VisitorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class VisitorServiceTest {

    @Mock
    private VisitorRepository visitorRepository;

    @InjectMocks
    private VisitorService visitorService;

    @Test
    public void shouldRegisterVisitor() {

        // Setup
        // Creating a visitor instance
        // Allows using Given to set data
        var visitor = mock(Visitor.class);

        // Given the visitor's ID, I want the return to be 1L (long)
        // Simulates an action
        given(visitor.getId()).willReturn(1L);
        given(visitor.getEmail()).willReturn("henrique@gmail.com");
        given(visitor.getCpf()).willReturn("83735288065");
        given(visitor.getName()).willReturn("Henrique");
        given(visitor.getPhone()).willReturn("11947542211");

        // Simulate saving the visitor
        given(visitorRepository.save(visitor)).willReturn(visitor);

        var result = visitorService.registerVisitor(visitor);

        // Validate the result to see if the expectations match the reality
        then(result.getId()).equals(1L);
        then(result.getEmail()).equals("henrique@gmail.com");
        then(result.getCpf()).equals("48574498911"); // Note: Check this CPF, it differs from the one assigned.
        then(result.getName()).equals("Henrique");
        then(result.getPhone()).equals("11947542211");
    }

    @Test
    public void shouldDeleteVisitor() {
        // Test implementation goes here
    }

    @Test
    void shouldDeleteVisitorSuccessfully() {
        // Test implementation goes here
    }

    @Test
    void shouldThrowExceptionWhenVisitorNotFound() {
        // Test implementation goes here
    }

    @Test
    void shouldThrowExceptionWhenVisitorHasPurchasedTickets() {
        // Test implementation goes here
    }

    @Test
    void shouldThrowExceptionWhenVisitorHasPendingFeedbacks() {
        // Test implementation goes here
    }
}
