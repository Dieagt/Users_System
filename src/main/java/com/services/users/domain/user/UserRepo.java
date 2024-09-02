package com.services.users.domain.user;

import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {


    User findByName(String userName);

    User findByEmail(String email);
}
