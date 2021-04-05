package com.example.or_task.Config;

import com.example.or_task.Model.Users;
import com.example.or_task.Repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class UsersConfig {
    @Bean
    CommandLineRunner commandLineRunner(UsersRepository usersRepository){
        return args -> {
           Users philipp =  new Users("Philipp", "lala");
           Users bujar =  new Users("Bujar", "a123");
           Users muharrem =  new Users("Muharrem", "abc");
           usersRepository.saveAll(List.of(philipp, bujar, muharrem));
        };
    }

}
