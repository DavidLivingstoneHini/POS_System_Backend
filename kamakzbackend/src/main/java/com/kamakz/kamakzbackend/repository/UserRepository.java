package com.kamakz.kamakzbackend.repository;

import com.kamakz.kamakzbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);


    // Custom query using @Query annotation
    @Query("SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
    List<User> findUsersByUsernameAndPassword(String username, String password);
}
