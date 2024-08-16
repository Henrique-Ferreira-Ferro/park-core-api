package com.ParqueCore.ParkBeto.exceptions;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static java.time.LocalDateTime.now;

@ControllerAdvice
public class HttpErrorExceptionHandler {

    private ResponseEntity<ApiError> buildErrorResponse(HttpStatus status, String message) {
        var error = new ApiError(status.value(), message, now());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> badRequest(BadRequestException exception) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ApiError> notFound(ObjectNotFoundException exception) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, "Não foi possivel encontrar " + exception.getEntityName());
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ApiError> Forbidden(ForbiddenException exception) {
        return buildErrorResponse(HttpStatus.FORBIDDEN, "Não há permissão para essa pagina: " + exception.getMessage());
    }
}
