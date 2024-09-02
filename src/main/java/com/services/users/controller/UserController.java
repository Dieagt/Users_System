package com.services.users.controller;

import com.services.users.domain.user.User;
import com.services.users.domain.user.UserRepo;
import com.services.users.domain.user.dto.CreateUserDto;
import com.services.users.domain.user.dto.ModifyUserDto;
import com.services.users.domain.user.dto.UserAccessDto;
import com.services.users.domain.user.dto.SimpleUserDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/users")
public class UserController {
    private UserRepo repo;

    public UserController(UserRepo repo){
        this.repo = repo;
    }

    @GetMapping
    public ResponseEntity<List<SimpleUserDto>> getUsers(){
        List<User> users = repo.findAll();
        return ResponseEntity.ok(users.stream().map(SimpleUserDto::new).toList());
    }

    @PostMapping
    public ResponseEntity<CreateUserDto> createUser(
            @RequestBody
            @Valid
            CreateUserDto userDto
    ){
        return ResponseEntity.ok(new CreateUserDto(repo.save(userDto.toUser())));
    }

    @GetMapping ("/{userEmail}")
    public ResponseEntity<UserAccessDto> logIn(
            @PathVariable
            String userEmail
    ){
        User user = repo.findByEmail(userEmail);
        //Auth.passw;
        //Aut.token;
        return ResponseEntity.ok(new UserAccessDto(user));
    }

    @PutMapping
    public ResponseEntity<UserAccessDto> modifyUser(
            @RequestBody
            @Valid
            ModifyUserDto newInfo
    ){
        User us = repo.findByEmail(newInfo.email());
        us.updateInfo(newInfo);
        return ResponseEntity.ok(new UserAccessDto(repo.save(us)));
    }

    @DeleteMapping
    public void deleteUser(
            @RequestBody
            User user
    ){
        repo.delete(repo.findByName(user.getName()));
    }

}

