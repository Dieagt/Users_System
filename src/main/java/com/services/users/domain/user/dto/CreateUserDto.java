package com.services.users.domain.user.dto;

import com.services.users.domain.user.User;

public record CreateUserDto(

        String name,
        String email,
        String location,
        String password
) {
    public CreateUserDto(User user){
        this(
                user.getName(),
                user.getEmail(),
                user.getLocation(),
                null
        );
    }

    public User toUser() {
        User user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        user.setLocation(this.location);
        user.setPassword(this.password);
        return user;
    }
}
