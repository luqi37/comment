package com.dao;

import com.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> select(User user);

    int delete(Long id);

    int update(User user);

    User selectById(Long id);

    int insert(User user);
}
