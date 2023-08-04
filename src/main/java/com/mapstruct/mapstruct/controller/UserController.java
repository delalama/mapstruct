package com.mapstruct.mapstruct.controller;

import com.mapstruct.mapstruct.model.User;
import com.mapstruct.mapstruct.model.UserDTO;
import com.mapstruct.mapstruct.service.LoginService;
import com.mapstruct.mapstruct.service.UserService;
import jakarta.validation.Valid;
import org.instancio.Instancio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    final UserService userService;

    final LoginService loginService;

    public UserController(UserService userService, LoginService loginService) {
        this.userService = userService;
        this.loginService = loginService;
    }

    @GetMapping("/person")
    private List<UserDTO> getAllPerson() {
        return userService.getAllPerson();
    }

    @GetMapping("/Person/{id}")
    private UserDTO getPerson(@PathVariable("id") int id) {
        return userService.getPersonById(id);
    }

    @DeleteMapping("/Person/{id}")
    private void deletePerson(@PathVariable("id") int id) {
        userService.delete(id);
    }

    @PostMapping("/person")
    private long savePerson(@RequestBody User User) {
        return userService.saveOrUpdate(User);
    }

    @PostMapping("/login")
    private Boolean login(@RequestBody @Valid UserDTO userDTO) {
        return loginService.login(userDTO);
    }
    @PostMapping("/createUser")
    private String createUser(@RequestBody UserDTO userDTO) {
        return loginService.create(userDTO);
    }

    @GetMapping("/RandomPersons")
    private Iterable<UserDTO> saveRandomPersons() {
        List<User> users = Instancio.ofList(User.class).size(50).create();

        return userService.saveOrUpdateList(users);
    }
}
