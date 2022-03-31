package com.deloitte.service;

import com.deloitte.controller.dto.UserDto;
import com.deloitte.model.User;
import com.deloitte.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(UserDto userDto) {
        // Transformation from DTO to entity upon calling the repository to persist a new user into the database
        logger.info("user dto values" + userDto);
        User user = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getUsername(), userDto.getPassword(), userDto.getEmailAddress(), userDto.getRole());
        return userRepository.save(user);
    }

}
