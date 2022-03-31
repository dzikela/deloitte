package com.deloitte.controller.dto;

public class TaskDto {
    private long id;
    private String name;
    private String description;
    private String lastModified;
    private UserDto user;

    public TaskDto() {
    }
    public TaskDto(String name, String description, long id, String lastModified) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.lastModified = lastModified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TaskDto [name=" + name + ", description=" + description + ", lastModified=" + lastModified + ", user=" + user + "]";
    }
}
