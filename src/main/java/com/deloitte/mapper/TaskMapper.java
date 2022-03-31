package com.deloitte.mapper;

import com.deloitte.controller.dto.TaskDto;
import com.deloitte.model.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskMapper {

    public List<TaskDto> mapToTaskDto(List<Task> task){
        List<TaskDto> tasksDto = new ArrayList<>();
         for (Task taskEntity : task){
             tasksDto.add(new TaskDto(taskEntity.getName(),taskEntity.getDescription(), taskEntity.getId(), taskEntity.getLastUpdated().toString()));
        }
        return tasksDto;
    }
}
