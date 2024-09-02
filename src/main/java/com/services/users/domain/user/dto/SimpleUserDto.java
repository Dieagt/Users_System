package com.services.users.domain.user.dto;

import com.services.users.domain.user.User;

public record SimpleUserDto(
        String name,
        String email
) {
    public SimpleUserDto(User user){
       this(
               user.getName(),
               user.getEmail());
    }
    public User toUser(){
        User user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        return user;
    }
}
