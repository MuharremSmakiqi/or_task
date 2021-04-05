package com.example.or_task.Controller;

import com.example.or_task.Model.Users;
import com.example.or_task.Repository.UsersRepository;
import com.example.or_task.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class UsersController {
    private final UsersService usersService;
    private final UsersRepository usersRepository;

    @Autowired
    public UsersController(UsersService usersService, UsersRepository usersRepository) {
        this.usersService = usersService;
        this.usersRepository = usersRepository;
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
    public RedirectView findUserGender(@PathVariable String name) {
        return usersService.findUserByName(name);
    }

}
