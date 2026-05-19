package com.projeto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projeto.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
}
