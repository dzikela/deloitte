package com.deloitte.service;

import com.deloitte.model.User;
import com.deloitte.controller.dto.UserDto;

public interface UserService {
    User save(UserDto userDto);
}
