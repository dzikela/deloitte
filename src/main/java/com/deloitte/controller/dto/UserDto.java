package com.deloitte.controller.dto;

import java.util.Collection;

public class UserDto {

    private String firstName;
    private String lastName;
    private String  username;
    private String  password;
    private String emailAddress;
    private String role;
    private Collection<TaskDto> tasks;

    public UserDto() {
    }
    public UserDto(String firstName, String lastName, String username, String  password, String emailAddress, String role, Collection<TaskDto> tasks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public Collection<TaskDto> getTasks() {
        return tasks;
    }

    public void setTasks(Collection<TaskDto> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "UserDto [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password=" + password + ", email=" + emailAddress + ", role=" + role + "]";
    }
}
