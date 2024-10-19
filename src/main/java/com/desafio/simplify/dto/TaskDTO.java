package com.desafio.simplify.dto;

import com.desafio.simplify.entities.Task;
import com.desafio.simplify.enums.TaskEnum;

public class TaskDTO {
    private Long id;
    private String name;
    private String description;
    private Boolean perform;
    private TaskEnum priority;

    public TaskDTO(){}

    public TaskDTO(Long id, String name, String description, Boolean perform, TaskEnum priority) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.perform = perform;
        this.priority = priority;
    }
    public TaskDTO(Task entity) {
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

    public TaskEnum getPriority() {
        return priority;
    }

    public void setPriority(TaskEnum priority) {
        this.priority = priority;
    }
}
