package com.hex.trs.service;

import com.hex.trs.exception.UsernameAlreadyExist;
import com.hex.trs.model.User;
import com.hex.trs.repository.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void checkUniqueness(String username) {
        Optional<User> optional = userRepository.findByUsername(username);
        if(optional.isPresent()){
            throw new UsernameAlreadyExist("Username needs to be unique");
        }
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
