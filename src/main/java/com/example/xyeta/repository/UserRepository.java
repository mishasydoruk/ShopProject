package com.example.xyeta.repository;

import com.example.xyeta.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends Repository<User, Integer> {

    @Query(value = "SELECT * FROM users ORDER BY first_name", nativeQuery = true)
    @Transactional(readOnly = true)
    List<User> findAll();

    @Query(value = "SELECT * FROM users WHERE uuid = :uuid", nativeQuery = true)
    @Transactional(readOnly = true)
    User findUserByUuid(@Param("uuid") UUID uuid);

    @Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    @Transactional(readOnly = true)
    User findUserByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM users WHERE username = :username", nativeQuery = true)
    @Transactional(readOnly = true)
    User findUserByUsername(@Param("username") String username);

    void save(User user);
}
