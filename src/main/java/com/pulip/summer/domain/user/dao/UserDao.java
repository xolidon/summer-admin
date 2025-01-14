package com.pulip.summer.domain.user.dao;

import com.pulip.summer.domain.user.dto.UserListDto;
import com.pulip.summer.domain.user.entity.User;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.pulip.summer.domain.user.entity.QUser.user;

@RequiredArgsConstructor
@Repository
public class UserDao {
    private final UserRepository userRepository;
    private final JPAQueryFactory queryFactory;
    private final UserMapper userMapper;

    public void save(User user) {
        userRepository.save(user);
    }

    public User findByLoginId(String loginId) {
        return queryFactory.selectFrom(user)
                .where(user.loginId.eq(loginId))
                .fetchOne();
    }

    public List<UserListDto> findAll() {
        return findAll(Pageable.unpaged());
    }

    public List<UserListDto> findAll(Pageable pageable) {
        JPAQuery<UserListDto> listQuery = queryFactory
                .select(Projections.fields(UserListDto.class, user.id, user.name, user.loginId, user.email, user.role, user.status, user.createdAt, user.updatedAt))
                .from(user)
                .orderBy(user.id.desc());

        if(pageable.isPaged()) {
            listQuery
                    .offset(pageable.getOffset())
                    .limit(pageable.getPageSize());
        }



        return listQuery.fetch();
    }

    public Page<UserListDto> searchPage(Pageable pageable) {
        JPAQuery<Long> countQuery = queryFactory
                .select(user.id.count())
                .from(user);
        return PageableExecutionUtils.getPage(findAll(pageable), pageable, countQuery::fetchOne);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
