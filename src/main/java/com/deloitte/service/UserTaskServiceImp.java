package com.deloitte.service;

import com.deloitte.controller.dto.TaskDto;
import com.deloitte.mapper.TaskMapper;
import com.deloitte.model.Task;
import com.deloitte.model.User;
import com.deloitte.repository.UserRepository;
import com.deloitte.repository.UserTaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Service
public class UserTaskServiceImp implements UserTaskService {

    private static final Logger logger = LoggerFactory.getLogger(UserTaskServiceImp.class);

    @Autowired
    UserTaskRepository userTaskRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskMapper mapper;

    Date date = new Date(Calendar.getInstance().getTime().getTime());

    @Override
    public TaskDto getTaskById(long id) {
        //Logic to get a single task for viewing in detailed
         Task task =  userTaskRepository.findTaskById(id);
        logger.info("Task detailed info "+ " " +  task);
        return new TaskDto(task.getName(), task.getDescription(), task.getId(), task.getLastUpdated().toString());
    }

    @Override
    public List<TaskDto> getAllTasksByUser() {
        //Logic to get username from Authentication Spring Security to which will be used to query the user
        // table that will be passed in the creation of the task.
        User user = getUserInfo();

        //Calling the all the tasks linked to a user by user Id
        List<Task> tasks = userTaskRepository.findTasksByUser(user);
        logger.info("Tasks linked to the user "+ " " +  tasks);
        return mapper.mapToTaskDto(tasks);
    }

    @Override
    public void deleteById(long id) {
        //Delete the task from the database by passing the task id
        logger.info("Task id to be deleted from the database "+ " " +  id);
        userTaskRepository.deleteById(id);
    }

    @Override
    public Task save(TaskDto taskDto) {
        // Transformation from DTO to entity upon calling the repository to get the user and persist a new task
        // for the logged-in user into the database
        logger.info("Task dto values to be converted to task entity" + taskDto);
        User user = getUserInfo();
        Task task = new Task(taskDto.getName(),taskDto.getDescription() , date , user);
        return userTaskRepository.save(task);
    }

    private User getUserInfo() {
        //Logic to get username from Authentication Spring Security to which will be used to query the user
        // table that will be passed in the creation and fetching of the tasks.
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        DeloitteUserDetails userDetails = (DeloitteUserDetails) auth.getPrincipal();
        User user = userRepository.findUserByUsername(userDetails.getUsername());
        logger.info("User information " + " " + user);
        return user;
    }
}
