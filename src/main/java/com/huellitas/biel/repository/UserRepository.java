package com.huellitas.biel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.huellitas.biel.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
