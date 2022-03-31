package com.deloitte.controller;

import com.deloitte.controller.dto.UserDto;
import com.deloitte.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserRegistrationController {

    private static final Logger logger = LoggerFactory.getLogger(UserTaskController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/registration", method = RequestMethod.POST)
    public RedirectView registerUser(RedirectAttributes redirectAttributes, @ModelAttribute UserDto userDto) {
        //Registration process to create a new user with roles
        logger.info("New registered user to be created " + " " + userDto);
        userService.save(userDto);
        String message = "Created user <b>" + userDto.getFirstName() + " " + "</b> ✨.";
        RedirectView redirectView = new RedirectView("/users", true);
        redirectAttributes.addFlashAttribute("userMessage", message);
        return redirectView;
    }
}
