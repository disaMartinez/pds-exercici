package com.example.pdsexercici.service;

import com.example.pdsexercici.entity.User;
import com.example.pdsexercici.repository.UserRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Collection<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty())
            throw new ServiceException("Unknow user");
        return optionalUser.get();
    }
}
