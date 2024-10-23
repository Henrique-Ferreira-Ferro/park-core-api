package com.ParkCore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT) // para definir o status HTTP 204 No Content
public class NoContentException extends RuntimeException {

    public NoContentException(String message) {
        super(message);
    }
}