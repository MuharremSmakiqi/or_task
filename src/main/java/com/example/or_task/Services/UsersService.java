package com.example.or_task.Services;

import com.example.or_task.Model.Users;
import com.example.or_task.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;
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


    public Users findUserByName(String name) {
        return usersRepository.findByName(name);
    }

    @Autowired
    RestTemplate restTemplate;
    public String getGender(String name) {
        String userName = usersRepository.findByName(name).getName();
        String url ="https://api.genderize.io/?name="+userName;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

       return restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
    }
}
