package com.pulip.summer.web;

import com.pulip.summer.domain.user.dto.UserJoinDto;
import com.pulip.summer.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
@Controller
@RequiredArgsConstructor
public class HomeController {
    private final UserService userService;

    @GetMapping("")
    public String home() {
        UserJoinDto joinUser = new UserJoinDto();
        joinUser.setLoginId("test");
        joinUser.setPassword("<PASSWORD>");
        joinUser.setEmail("<EMAIL>");

        userService.addUser(joinUser);
        return "home";
    }


}
