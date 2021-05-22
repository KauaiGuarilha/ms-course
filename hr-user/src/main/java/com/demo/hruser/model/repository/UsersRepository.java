package com.demo.hruser.model.repository;

import com.demo.hruser.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByEmail(String email);
}
