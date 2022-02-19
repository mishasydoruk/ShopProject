package com.example.xyeta.repository;

import com.example.xyeta.models.Role;
import com.example.xyeta.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query(value = "SELECT * FROM roles WHERE name = :name", nativeQuery = true)
    @Transactional(readOnly = true)
    Role findRoleByName(@Param("name") String name);
}
