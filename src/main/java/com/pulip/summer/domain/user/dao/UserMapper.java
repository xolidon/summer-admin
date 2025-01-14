package com.pulip.summer.domain.user.dao;

import com.pulip.summer.domain.user.dto.UserListDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
interface UserMapper {
    List<UserListDto> findAll();
}
