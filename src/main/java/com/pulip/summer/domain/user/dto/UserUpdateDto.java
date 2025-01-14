package com.pulip.summer.domain.user.dto;

import com.pulip.summer.domain.user.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDto {
    private Long id;
    private String name;
    private String loginId;
    private String password;
    private String email;
    private String role;
    private String status;

    public User toEntity() {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setLoginId(loginId);
        user.setPassword(password);
        user.setEmail(email);
        user.setRole(role);
        user.setStatus(status);

        return user;
    }
}
