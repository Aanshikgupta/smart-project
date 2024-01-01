package com.smartcomputers.smartproject.auth.role.repository;

import com.smartcomputers.smartproject.auth.role.entity.Role;
import com.smartcomputers.smartproject.auth.role.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(RoleEnum roleEnum);
}
