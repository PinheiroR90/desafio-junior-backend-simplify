package com.desafio.simplify.services;

import com.desafio.simplify.dto.TaskDTO;
import com.desafio.simplify.entities.Task;
import com.desafio.simplify.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Transactional
    public List<Task> getAllTasks(){
        return taskRepository.findAll().stream().toList();
    }
    @Transactional
    public TaskDTO getByTaskId(Long userId){
        Task user = taskRepository.findById(userId).orElseThrow(()-> new RuntimeException("nenhum usuario"));
        return new TaskDTO(user);
    }

    public TaskDTO saveTask(TaskDTO user){

        Task entity = new Task();
        copyEntityForDto(entity,user);
        try{
            entity = taskRepository.save(entity);
            return new TaskDTO(entity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public TaskDTO updateTask(Long id, TaskDTO user){

        Task user1 = taskRepository.getReferenceById(id);

        copyEntityForDto(user1,user);

        user1 = taskRepository.save(user1);
        return new TaskDTO(user1);

    }

    public void deleteTask(Long userId){
        try{
            taskRepository.deleteById(userId);
        }catch (Exception e){
            throw new RuntimeException("Error ao deletar");
        }
    }

    public void copyEntityForDto(Task entity, TaskDTO dto){
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPerform(dto.getPerform());
        entity.setPriority(dto.getPriority());
    }

}
