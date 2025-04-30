package com.example.library.data.repository;

import com.example.library.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(Integer id);

    User findUserByName(String userName);
}