package com.example.genchi.service;

import com.example.genchi.entities.User;
import com.example.genchi.model.CustomerDto;
import com.example.genchi.model.UserDto;
import com.example.genchi.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository ;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> doListUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> toUserDto(user)).collect(Collectors.toList());
    }



    private UserDto toUserDto(User user) {
        UserDto dto = new UserDto();

        return dto;
    }

    public UserDetails loadUserByUsername(String email) {
        return null;
    }
}
