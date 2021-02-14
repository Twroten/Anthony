package com.wroten.mybatis.hello.mapper;

import com.wroten.mybatis.hello.domain.User;

import java.util.List;

public interface UserMapper {
    void save(User user);

    void delete(Long id);

    void update(User user, Long id);

    User get(Long id);

    List<User> listAll();
}
