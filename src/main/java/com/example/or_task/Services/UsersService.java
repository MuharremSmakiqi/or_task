package com.example.or_task.Services;

import com.example.or_task.Model.Users;
import com.example.or_task.Repository.UsersRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getUsers(){
        return usersRepository.findAll();
    }

    public Users findUserById(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    @JsonIgnore
    String probability;
    String count;
    public RedirectView findUserByName(String name) {
        RedirectView redirectView = new RedirectView();
        String userName = usersRepository.findByName(name).getName();
        String url ="https://api.genderize.io/?name="+userName;
        redirectView.setUrl(url);
        return redirectView;
    }
}
