package com.example.or_task.Controller;

import com.example.or_task.Model.Users;
import com.example.or_task.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/")
    public List<Users> getUsers(){
        return usersService.getUsers();
    }

    @GetMapping("/uuid/{id}")
    public Users findUserById(@PathVariable Long id) {
        return usersService.findUserById(id);
    }
    @GetMapping("/{name}")
    public Users findUserByName(@PathVariable String name) {
         return usersService.findUserByName(name);
    }

    @RequestMapping(value = "/gender-for-name/{name}")
    public String getGender(@PathVariable("name") String name) {
       return usersService.getGender(name);
    }

}
