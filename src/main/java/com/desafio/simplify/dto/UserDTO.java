package com.desafio.simplify.dto;

import com.desafio.simplify.entities.User;
import com.desafio.simplify.enums.UserEnum;

public class UserDTO {
    private Long id;
    private String name;
    private String description;
    private Boolean perform;
    private UserEnum priority;

    public UserDTO(){}

    public UserDTO(Long id, String name, String description, Boolean perform, UserEnum priority) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.perform = perform;
        this.priority = priority;
    }
    public UserDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        perform = entity.getPerform();
        priority = entity.getPriority();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getPerform() {
        return perform;
    }

    public void setPerform(Boolean perform) {
        this.perform = perform;
    }

    public UserEnum getPriority() {
        return priority;
    }

    public void setPriority(UserEnum priority) {
        this.priority = priority;
    }
}
