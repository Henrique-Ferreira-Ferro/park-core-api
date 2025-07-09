package com.ParkCore.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventDTO {

	private Long id;
    private String name;
    private String description;
    private LocalDate eventDate;
    private AttractionDTO attraction;
    private String status;
    @ElementCollection
    private List<String> requiredResources;
    private List<VisitorDTO> confirmedParticipants;
    private List<NotificationDTO> notifications;
}
