package io.github.ramajd.freetasks.mappers;

import io.github.ramajd.freetasks.domain.dto.TaskListDto;
import io.github.ramajd.freetasks.domain.entities.TaskList;

public interface TaskListMapper {

    TaskList fromDto(TaskListDto dto);

    TaskListDto toDto(TaskList taskList);
}
