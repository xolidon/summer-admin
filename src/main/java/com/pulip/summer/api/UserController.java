package com.pulip.summer.api;

import com.pulip.summer.core.dto.ApiResponse;
import com.pulip.summer.core.dto.PageRequest;
import com.pulip.summer.core.dto.PageResponse;
import com.pulip.summer.domain.user.dto.UserJoinDto;
import com.pulip.summer.domain.user.dto.UserUpdateDto;
import com.pulip.summer.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public ApiResponse page(Pageable pageable) {
        return ApiResponse.builder()
                .put("page", PageResponse.of(userService.getUserList(pageable)))
                .ok();
    }

    @PostMapping("")
    public ApiResponse add(@RequestBody UserJoinDto joinUser) {
        return ApiResponse.builder()
                .put("users", userService.addUser(joinUser))
                .ok();
    }

    @PutMapping("")
    public ApiResponse update(@RequestBody UserUpdateDto updateUser) {
        return ApiResponse.builder()
                .put("users", userService.updateUser(updateUser))
                .ok();
    }

    @DeleteMapping("{id}")
    public ApiResponse delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return ApiResponse.builder().ok();
    }
}
