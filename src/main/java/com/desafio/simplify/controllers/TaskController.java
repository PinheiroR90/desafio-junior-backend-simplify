package com.desafio.simplify.controllers;

import com.desafio.simplify.dto.TaskDTO;
import com.desafio.simplify.entities.Task;
import com.desafio.simplify.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

    @Autowired
    private TaskService userService;

@GetMapping
public ResponseEntity<List<Task>> taskList(){
    List<Task> list = userService.getAllTasks();
    return ResponseEntity.ok(list);
}

    @GetMapping(value = "/{id}")
    public ResponseEntity<TaskDTO> taskById(@PathVariable Long id){
        TaskDTO userId= userService.getByTaskId(id);
        return ResponseEntity.ok(userId);
    }

   @PostMapping
   public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO user){
       TaskDTO newUser = userService.saveTask(user);
       URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
               .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(newUser);
   }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO user){
      TaskDTO userDTO = userService.updateTask(id, user);
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        userService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

}
