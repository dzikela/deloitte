package com.deloitte.service;

import com.deloitte.controller.dto.TaskDto;
import com.deloitte.model.Task;

import java.util.List;

public interface UserTaskService {
    TaskDto getTaskById(long id);

    List<TaskDto> getAllTasksByUser();

    void deleteById(long id);

    Task save(TaskDto taskDto);
}
