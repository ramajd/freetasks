package io.github.ramajd.freetasks.controllers;

import io.github.ramajd.freetasks.domain.dto.TaskListDto;
import io.github.ramajd.freetasks.domain.entities.TaskList;
import io.github.ramajd.freetasks.mappers.TaskListMapper;
import io.github.ramajd.freetasks.services.TaskListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/task-lists")
public class TaskListController {

    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;

    public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }

    @GetMapping
    public List<TaskListDto> listTaskLists() {
        return taskListService.listTaskLists()
                .stream()
                .map(taskListMapper::toDto)
                .toList();
    }

    @PostMapping
    public TaskListDto createTaskList(@RequestBody TaskListDto dto) {
        TaskList createdTaskList =  taskListService.createTaskList(
                taskListMapper.fromDto(dto)
        );
        return taskListMapper.toDto(createdTaskList);
    }

    @GetMapping(path = "/{task_list_id}")
    public Optional<TaskListDto> getTaskList(@PathVariable("task_list_id") UUID taskListId) {
        return taskListService.getTaskList(taskListId)
                .map(taskListMapper::toDto);
    }

    @PutMapping(path = "/{task_list_id}")
    public TaskListDto updateTaskList(
            @PathVariable("task_list_id") UUID taskListId,
            @RequestBody TaskListDto dto
    ) {
         TaskList updatedTaskList = taskListService.updateTaskList(
                 taskListId,
                 taskListMapper.fromDto(dto)
         );
         return taskListMapper.toDto(updatedTaskList);
    }
}
