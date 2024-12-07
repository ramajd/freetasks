package io.github.ramajd.freetasks.domain.dto;

import io.github.ramajd.freetasks.domain.entities.TaskPriority;
import io.github.ramajd.freetasks.domain.entities.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDateTime dueData,
        TaskPriority priority,
        TaskStatus status
) {
}
