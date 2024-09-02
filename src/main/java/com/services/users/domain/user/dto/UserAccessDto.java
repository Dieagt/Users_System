package com.services.users.domain.user.dto;

import com.services.users.domain.user.User;

import java.time.ZonedDateTime;

public record UserAccessDto(
    String name,
    String email,
    String phone,
    String location,
    boolean admin,
    ZonedDateTime creation
) {
    public UserAccessDto(User user){
        this(
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                user.getLocation(),
                user.getAdmin(),
                user.getCreation()
        );
    }
}
