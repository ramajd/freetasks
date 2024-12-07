package io.github.ramajd.freetasks.mappers;

import io.github.ramajd.freetasks.domain.dto.TaskDto;
import io.github.ramajd.freetasks.domain.entities.Task;

public interface TaskMapper {

    Task fromDto(TaskDto dto);

    TaskDto toDto(Task task);
}
