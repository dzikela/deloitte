package com.deloitte.controller;

import com.deloitte.controller.dto.TaskDto;
import com.deloitte.service.UserTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class UserTaskController {

    private static final Logger logger = LoggerFactory.getLogger(UserTaskController.class);

    @Autowired
    private UserTaskService userTaskService;

    @GetMapping("/tasks")
    public String showTasks(Model model) {
        List<TaskDto> tasks = userTaskService.getAllTasksByUser();
        logger.info("Available tasks for user " + " " + tasks);
        model.addAttribute("tasks", tasks);
        model.addAttribute("taskDto", new TaskDto());
        return "tasks";
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public RedirectView createTask(RedirectAttributes redirectAttributes, @ModelAttribute TaskDto taskDto) {
        userTaskService.save(taskDto);
        String message = "Created task name <b>" + taskDto.getName() + " " + "</b> ✨.";
        RedirectView redirectView = new RedirectView("/tasks", true);
        redirectAttributes.addFlashAttribute("userMessage", message);
        return redirectView;
    }

    @GetMapping("/task/{id}")
    public String getTaskForUserById(Model model, @PathVariable("id") long id) {
        // Get task by id
        logger.info("Task id for finding a task " + " " + id);
        TaskDto task = userTaskService.getTaskById(id);
        model.addAttribute("task", task);
        model.addAttribute("taskDto", new TaskDto());
        return "view";
    }

    @GetMapping("/delete/{id}")
    public RedirectView deleteTask(@PathVariable("id") long id ) {
        // call delete task method via the service
        logger.info("Task id for deleting the task " + " " + id);
        this.userTaskService.deleteById(id);
        RedirectView redirectView = new RedirectView("/tasks", true);
        return redirectView;
    }
}