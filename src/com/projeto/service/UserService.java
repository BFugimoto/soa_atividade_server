package com.projeto.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projeto.model.User;
import com.projeto.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> listar() {
        return this.userRepository.findAll();
    }

    public User salvar(User user) {
        return this.userRepository.save(user);
    }

    public Optional<User> getPorId(long id) {
        return this.userRepository.findById(id);
    }

    public void excluir(long id) {
        this.userRepository.deleteById(id);
    }
}
