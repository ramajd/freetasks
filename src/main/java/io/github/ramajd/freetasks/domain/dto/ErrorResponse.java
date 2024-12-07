package io.github.ramajd.freetasks.domain.dto;

public record ErrorResponse(
        int status,
        String message,
        String details
) {
}
