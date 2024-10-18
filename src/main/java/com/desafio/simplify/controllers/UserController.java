package com.desafio.simplify.controllers;

import com.desafio.simplify.dto.UserDTO;
import com.desafio.simplify.entities.User;
import com.desafio.simplify.repositories.UserRepository;
import com.desafio.simplify.services.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

@GetMapping
public ResponseEntity<List<User>> userList(){
    List<User> list = userService.getAllUsers();
    return ResponseEntity.ok(list);
}

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> userById(@PathVariable Long id){
        UserDTO userId= userService.getByUserId(id);
        return ResponseEntity.ok(userId);
    }

   @PostMapping
   public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user){
       UserDTO newUser = userService.saveUser(user);
       URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
               .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(newUser);
   }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO user){
      UserDTO userDTO = userService.updateUser(id, user);
        return ResponseEntity.ok(userDTO);
    }

}
