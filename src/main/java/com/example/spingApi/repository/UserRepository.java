package com.example.spingApi.repository;

import com.example.spingApi.restServices.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByFirstName(String username);
}
