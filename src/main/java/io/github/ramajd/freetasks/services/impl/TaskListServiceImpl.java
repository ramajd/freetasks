package io.github.ramajd.freetasks.services.impl;

import io.github.ramajd.freetasks.domain.entities.TaskList;
import io.github.ramajd.freetasks.repositories.TaskListRepository;
import io.github.ramajd.freetasks.services.TaskListService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;

    public TaskListServiceImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<TaskList> listTaskLists() {
        return taskListRepository.findAll();
    }
}
