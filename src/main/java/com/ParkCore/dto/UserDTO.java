package com.ParkCore.dto;

import com.ParkCore.enums.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
	
	private Long id;
	private String name;
	private String password;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
	private UserRole role;
	
	
}
