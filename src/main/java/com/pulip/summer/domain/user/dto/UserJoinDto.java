package com.pulip.summer.domain.user.dto;

import com.pulip.summer.domain.user.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserJoinDto {
    private String name;
    private String loginId;
    private String password;
    private String email;

    public User toEntity() {
        User user = new User();
        user.setName(name);
        user.setLoginId(loginId);
        user.setPassword(password);
        user.setEmail(email);

        return user;
    }
}
