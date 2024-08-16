package com.ParqueCore.ParkBeto.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ApiError {
    private int statusCode;
    private String message;
    private LocalDateTime date;
}
