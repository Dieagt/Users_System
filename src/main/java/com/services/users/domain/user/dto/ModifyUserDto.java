package com.services.users.domain.user.dto;

public record ModifyUserDto(
        String name,
        String email,
        String phone,
        String location
) {
}
