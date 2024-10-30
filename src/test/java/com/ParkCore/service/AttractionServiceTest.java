package com.ParkCore.service;

import com.ParkCore.repository.AttractionRepository;
import com.ParkCore.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AttractionServiceTest {

    @Mock
    private AttractionRepository attractionRepository;

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private AttractionService atracao;

    @Test
    public void shouldVerifyisNomeUnique() {

    }

    @Test
    public void shouldCreateAtracao() {

    }

}
