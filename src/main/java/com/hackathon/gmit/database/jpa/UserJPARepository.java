/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.database.jpa;

import com.hackathon.gmit.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJPARepository extends JpaRepository<Users,Long> {
    Optional<Users> findByUsernameAndDeleteAtNull(String username);
    Optional<Users> findByEmailAndDeleteAtNull(String email);
    Users findByIdAndDeleteAtIsNull(Long userId);

}
