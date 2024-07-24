package com.course.web_users_api.service;

import com.course.web_users_api.model.User;
import com.course.web_users_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }

    public User saveUser(User user) {
        return repository.save(user);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    public User putUser(Long id, User user) {
        if(repository.existsById(id)) {
            user.setId(id);
            return repository.save(user);
        } else {
            throw new RuntimeException("Usuário não encontrado com id: " + id);
        }

    }

}
