package com.pulip.summer.domain.user.service;

import com.pulip.summer.core.dto.PageRequest;
import com.pulip.summer.domain.user.dto.UserJoinDto;
import com.pulip.summer.domain.user.dto.UserUpdateDto;
import com.pulip.summer.domain.user.dto.UserListDto;
import com.pulip.summer.domain.user.entity.User;
import com.pulip.summer.domain.user.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserDao userDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByLoginId(username);

        return null;
    }

    public User addUser(UserJoinDto joinUserDto) {
        User user = joinUserDto.toEntity();
        userDao.save(user);
        return user;
    }

    public Page<UserListDto> getUserList(Pageable pageable) {
        return userDao.searchPage(pageable);
    }

    public User updateUser(UserUpdateDto updateUser) {
        User user = updateUser.toEntity();
        userDao.save(user);
        return user;
    }

    public void deleteUser(Long id) {
        User user = new User();
        user.setId(id);
        userDao.delete(user);
    }
}
