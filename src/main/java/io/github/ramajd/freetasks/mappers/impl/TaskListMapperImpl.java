package io.github.ramajd.freetasks.mappers.impl;

import io.github.ramajd.freetasks.domain.dto.TaskListDto;
import io.github.ramajd.freetasks.domain.entities.Task;
import io.github.ramajd.freetasks.domain.entities.TaskList;
import io.github.ramajd.freetasks.domain.entities.TaskStatus;
import io.github.ramajd.freetasks.mappers.TaskListMapper;
import io.github.ramajd.freetasks.mappers.TaskMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskListMapperImpl implements TaskListMapper {

    private final TaskMapper taskMapper;

    public TaskListMapperImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskList fromDto(TaskListDto dto) {
        return  new TaskList(
                dto.id(),
                dto.title(),
                dto.description(),
                Optional.ofNullable(dto.tasks())
                        .map(tasks -> tasks.stream()
                                .map(taskMapper::fromDto)
                                .toList()
                        ).orElse(null),
                null,
                null
        );
    }

    @Override
    public TaskListDto toDto(TaskList taskList) {
        return new TaskListDto(
                taskList.getId(),
                taskList.getTitle(),
                taskList.getDescription(),
                Optional.ofNullable(taskList.getTasks())
                        .map(List::size)
                        .orElse(0),
                calculateTaskListProgress(taskList.getTasks()),
                Optional.ofNullable(taskList.getTasks())
                        .map(tasks ->
                                tasks.stream().map(taskMapper::toDto).toList()
                        ).orElse(null)
        );
    }


    private Double calculateTaskListProgress(List<Task> tasks) {
        if (tasks == null) {
            return null;
        }

        long closedTasksCount = tasks.stream().filter(task ->
                TaskStatus.CLOSED == task.getStatus()
        ).count();

        return (double)closedTasksCount / tasks.size();
    }

}
