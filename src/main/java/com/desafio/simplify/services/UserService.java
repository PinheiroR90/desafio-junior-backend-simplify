package com.desafio.simplify.services;

import com.desafio.simplify.dto.UserDTO;
import com.desafio.simplify.entities.User;
import com.desafio.simplify.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public List<User> getAllUsers(){
        return userRepository.findAll().stream().toList();
    }
    @Transactional
    public UserDTO getByUserId(Long userId){
        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("nenhum usuario"));
        return new UserDTO(user);
    }

    public UserDTO saveUser(UserDTO user){

        User entity = new User();
        copyEntityForDto(entity,user);
        try{
            entity = userRepository.save(entity);
            return new UserDTO(entity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public UserDTO updateUser(Long id, UserDTO user){

        User user1 = userRepository.getReferenceById(id);

        copyEntityForDto(user1,user);

        user1 = userRepository.save(user1);
        return new UserDTO(user1);

    }

    public void copyEntityForDto(User entity, UserDTO dto){
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPerform(dto.getPerform());
        entity.setPriority(dto.getPriority());
    }

}
