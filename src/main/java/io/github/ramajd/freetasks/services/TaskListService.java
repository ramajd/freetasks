package io.github.ramajd.freetasks.services;

import io.github.ramajd.freetasks.domain.entities.TaskList;

import java.util.List;

public interface TaskListService {

    List<TaskList> listTaskLists();
}
